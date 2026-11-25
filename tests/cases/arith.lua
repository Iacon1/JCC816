function check()
	expect_eq(read16("sum"), 42, "sum")
	expect_eq(read16("diff"), 958, "diff")
	expect_eq(read8("masked"), 0xA0, "masked")
	expect_eq(read16("neg"), 0x10000 - 42, "neg")
end
