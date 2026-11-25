function check()
	expect_eq(read8("pt"), 15, "pt.x")
	expect_eq(read16("pt", 1), 1000, "pt.y")
	expect_eq(read16("via_ptr"), 1001, "via_ptr")
end
