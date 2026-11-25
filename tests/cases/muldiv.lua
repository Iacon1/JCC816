function check()
	expect_eq(read16("prod"), 12340, "a * b")
	expect_eq(read16("quot"), 123, "a / b")
	expect_eq(read16("rem"), 4, "a % b")
end
