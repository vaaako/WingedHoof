package nut.wingedhoof.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	public static enum EnumType implements IStringSerializable {
		// Max = 16
		AMBER("amber", 0),
		PALLADIUM("palladium", 1);

		private static final EnumType[] META_LOOKUP = new EnumType[values().length];

		private final String name;
		private final String unlocializedName;
		private final int meta;

		private EnumType(String name, int meta)  {
			this(name, name, meta);
		}

		private EnumType(String name, String unlocializedName, int meta) {
			this.name = name;
			this.unlocializedName = name;
			this.meta = meta;
		}

		static {
			for(EnumType enumType : values()) {
				META_LOOKUP[enumType.getMeta()] = enumType;
			}
		}

		public static EnumType byMetadata(int meta) {
			return META_LOOKUP[meta];
		}

		@Override
		public String toString() {
			return this.name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public String getUnlocializedName() {
			return this.unlocializedName;
		}

		public int getMeta() {
			return this.meta;
		}
	}
}