-- Run by Mesen --testrunner as: SYM table (from the ROM's .dbg) + this file + <test>.lua.
-- Waits for the C global test_done to become nonzero, then runs the test's check().
-- Exit code: 0 = pass, 1 = an expectation failed, 2 = error or timeout.

local failed = false

local function addr(sym, off) return assert(SYM[sym], "no symbol " .. sym) + (off or 0) end
function read8(sym, off)  return emu.read(addr(sym, off), emu.memType.snesMemory, false) end
function read16(sym, off) return emu.read16(addr(sym, off), emu.memType.snesMemory, false) end

function expect_eq(actual, expected, what)
	if actual ~= expected then
		print(string.format("FAIL: %s: expected %s, got %s", what, expected, actual))
		failed = true
	end
end

if SYM.test_done == nil then
	print("no test_done global")
	emu.stop(2)
end

local frame = 0
emu.addEventCallback(function()
	frame = frame + 1
	if read8("test_done") ~= 0 then
		local ok, err = pcall(check)
		if not ok then print(err) end
		emu.stop(not ok and 2 or failed and 1 or 0)
	elseif frame > 600 then
		print("timed out waiting for test_done")
		emu.stop(2)
	end
end, emu.eventType.endFrame)
