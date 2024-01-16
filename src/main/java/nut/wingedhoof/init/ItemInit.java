package nut.wingedhoof.init;

import nut.wingedhoof.WingedHoof;
import nut.wingedhoof.init.ItemInit;
import nut.wingedhoof.items.ItemBase;
import nut.wingedhoof.items.armor.ArmorBase;

import nut.wingedhoof.items.tools.ToolSword;
import nut.wingedhoof.items.tools.ToolAxe;
import nut.wingedhoof.items.tools.ToolPickaxe;
import nut.wingedhoof.items.tools.ToolShovel;
import nut.wingedhoof.items.tools.ToolHoe;
import nut.wingedhoof.items.tools.ToolItem;

import nut.wingedhoof.interfaces.IRegisterable;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.inventory.EntityEquipmentSlot;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
	// All items
	public static final List<Item> ITEMS = new ArrayList<Item>();

	/**
	 * MATERIAL */
	public static final ToolMaterial TOOL_PALLADIUM = EnumHelper.addToolMaterial("tool_palladium",
		3,        // Harvest Level
		2031,     // Durability
		12.0f,    // Efficiency (not used for swords)
		9.0f - 4, // Damage (It sums base damage (e.g. sword base damage is +4))
		12        // Enchantability
	);

	public static final ToolMaterial TOOL_HORN = EnumHelper.addToolMaterial("tool_horn",
		2,        // Harvest Level
		250,      // Durability
		6.0f,     // Efficiency (not used for swords)
		6.0f - 4, // Damage (It sums base damage (e.g. sword base damage is +4))
		12        // Enchantability
	);

	/**
	 * AMOR */
	public static final ArmorMaterial ARMOR_PALLADIUM = EnumHelper.addArmorMaterial("armor_palladium", WingedHoof.MODID + ":palladium",
		400 / 5,                           // Durability (mutiplied by base 5 for some reason)
		new int[]{ 5, 10, 12, 5 },         // Damage Reduction (HEAD, LEG, CHEST, BOOT)
		12,                                // Enchantability
		SoundEvents.ITEM_ARMOR_EQUIP_IRON, // Sound on equip
		2.5f                               // Toughness
	); 



	/**
	 * ITEMS */
	public static final Item AMBER = new ItemBase("amber");
	public static final Item PALLADIUM_INGOT = new ItemBase("palladium_ingot");

	public static final Item COW_HORN = new ItemBase("cow_horn");

	/**
	 * TOOLS */ 
	// PALADDIUM //
	public static final Item PALLADIUM_SWORD = new ToolSword("palladium_sword", TOOL_PALLADIUM);
	public static final Item PALLADIUM_AXE = new ToolAxe("palladium_axe", TOOL_PALLADIUM, 12.0f, 1.0f);
	public static final Item PALLADIUM_PICKAXE = new ToolPickaxe("palladium_pickaxe", TOOL_PALLADIUM);
	public static final Item PALLADIUM_SHOVEL = new ToolShovel("palladium_shovel", TOOL_PALLADIUM);
	public static final Item PALLADIUM_HOE = new ToolHoe("palladium_hoe", TOOL_PALLADIUM);

	// HORN //
	public static final Item HORN_SPANCAXOTA = new ToolItem("horn_spancaxota", TOOL_HORN, 9.0f, 0.8f);

	// public static final Item PALLADIUM_AXE = new ToolAxe("palladium_axe", TOOL_HORN, 9.0f, 0.8f);

	/**
	 * ARMOR */
	public static final Item PALLADIUM_HELMET = new ArmorBase("palladium_helmet", ARMOR_PALLADIUM, 0, EntityEquipmentSlot.HEAD);
	public static final Item PALLADIUM_CHESTPLATE = new ArmorBase("palladium_chestplate", ARMOR_PALLADIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item PALLADIUM_LEGGINS = new ArmorBase("palladium_leggins", ARMOR_PALLADIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item PALLADIUM_BOOTS = new ArmorBase("palladium_boots", ARMOR_PALLADIUM, 3, EntityEquipmentSlot.FEET);



	// If create an item that is not IRegisterable, make a intanceof check before registerItemModel
	public static void registerModels() {
		for(Item item : ItemInit.ITEMS) {
			if(item instanceof IRegisterable) {
				((IRegisterable)item).registerItemModel();
			}
		}
	}
}



/*
- HARVEST LEVEL -
0 = WOOD/GOLD
1 = STONE
2 = IRON
3 = DIAMOND

- DURABILITY -
32    = GOLD
59    = WOOD
131   = STONE
250   = IRON
1561  = DIAMOND
2031  = DIAMOND

- EFFICIENCY -
2  = WOOD
4  = STONE
6  = IRON
8  = DIAMOND
12 = GOLD
*/




/*
- ARMOR STATS MEANING -
DURABILITY     = How many damage can the armor take before break
REDUCTION      = Damage absorved by the armor (e.g. 3 = Damage - 3)
ENCHANTABILITY = How often will receive good enchantment
SOUND          = What sound play on equip
TOUGHNESS      = Resistance for certain types of damage (explosion for example)

- DURABILITY -
LOW    = 1 - 50
MEDIUM = 51 - 100
HIGH   = 101 - 200

- DAMAGE REDUCTION -
LOW    = 1 - 5
MEDIUM = 6 - 10
HIGH   = 11 - 20

- TOUGHNESS -
LOW    = 0.5 - 1.5
MEDIUM = 1.6 - 2.5
HIGH   = 2.6 - 3.0
*/




/*
- ENCHANTABILITY -
LOW    = 1 - 10
MEDIUM = 11 - 20
HIGH   = 21 - 30


- BASE DAMAGE -
SWORD = 4
AXE = 7
PICKAXE = 2
SHOVEl = 2.5
HOE = 1

*/