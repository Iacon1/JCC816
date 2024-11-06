function dump(o)
   if type(o) == 'table' then
      local s = '{ '
      for k,v in pairs(o) do
         if type(k) ~= 'number' then k = '"'..k..'"' end
         s = s .. '['..k..'] = ' .. dump(v) .. ','
      end
      return s .. '} '
   else
      return tostring(o)
   end
end


text = ""
function readChar()
	c = string.char(emu.getState()["cpu.a"] & 0xFF)
	if c == '\0' then
		emu.log(text)
		text = ""
	else
		text = text .. c
	end
end

--Register some code (printInfo function) that will be run at the end of each frame
text = ""
emu.addMemoryCallback(readChar, emu.callbackType.write, 0x006000);