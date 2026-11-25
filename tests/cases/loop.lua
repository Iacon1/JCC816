function check()
	expect_eq(read16("total"), 140, "total")
	for i = 0, 7 do
		expect_eq(read8("squares", i), i * i, "squares[" .. i .. "]")
	end
end
