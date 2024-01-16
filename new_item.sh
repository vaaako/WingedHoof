#!/bin/bash

CORRECT_USAGE="Correct Usage: new_item (-r | -i | -t | -b) item_id \"Item Name\""

MOD_ID="wingedhoof"
RESOURCES="src/main/resources/assets/wingedhoof"

MODEL_ITEM="$RESOURCES/models/item"
MODEL_ITEM_BLOCK="$RESOURCES/models/block"
BLOCK_STATE="$RESOURCES/blockstates"
RECIPES="$RESOURCES/recipes"

LANG_FILE="$RESOURCES/lang/en_us.lang"
LANG_PREFIX="item"

ITEM_TYPE="$1"
ITEM_ID="$2"
ITEM_NAME="$3"



# New recipe
if [ $ITEM_TYPE == "-r" ]; then
	if [ -z "$ITEM_ID" ]; then
		echo -e "Invalid Usage: Item id was expected\nnew_item -r item_id"
		exit
	fi

	FULL_PATH="$RECIPES/$ITEM_ID.json"

	if [ -e $FULL_PATH ]; then
		echo -e "The file $ITEM_ID.json alredy exists on some of the folders: \"models/item\", \"models/block\" or \"blockstates\"!!! \nYou almost Overwrited it!"
		exit
	fi

	echo -e "{\n\t\"type\": \"minecraft:crafting_shaped\",\n\t// \"group\": \"wingedhoof:group_here\",\n\t\"pattern\": [\n\t\t\"I\",\n\t\t\"\",\n\t\t\"\"\n\t],\n\n\t\"key\": {\n\t\t\"I\": { \"item\": \"wingedhoof:item_id\" }\n\t},\n\n\t\"result\": {\n\t\t\"item\": \"wingedhoof:$ITEM_ID\",\n\t\t\"count\": 1\n\t}\n}" > $FULL_PATH
	
	echo -e "Recipe of $ITEM_ID added succesfully! \nYou need to edit resources/recipes/$ITEM_ID.json to make your recipe work!"

	exit
fi




# Check if usage is valid
if [ $ITEM_TYPE != "-i" ] && [ $ITEM_TYPE != "-b" ] && [ $ITEM_TYPE != "-t" ]; then
	echo -e "Invalid Usage: Expected some flag as argument \n$CORRECT_USAGE"
	exit
fi

if [ -z "$ITEM_ID" ]; then
	echo -e "Invalid Usage: Item id was expected\n$CORRECT_USAGE"
	exit
fi

if [ -z "$ITEM_NAME" ]; then
	echo -e "Invalid Usage: Item name was expected\n$CORRECT_USAGE"
	exit
fi

if [ "$#" -gt 3 ]; then
	echo -e "Invalid Usage: The maximum number of arguments is 4, you may have typed something wrong\n$CORRECT_USAGE"
	exit
fi


# Add new item
if [ $ITEM_TYPE == "-i" ]; then
	FULL_PATH="$MODEL_ITEM/$ITEM_ID.json"

	# Check if item alredy exists
	if [ -e $FULL_PATH ]; then
		echo -e "The file $ITEM_ID.json alredy exists!!! \nYou almost Overwrited it!"
		exit
	fi

	# Add model json
	echo -e "{\n\t\"parent\": \"item/generated\",\n\t\"textures\": {\n\t\t\"layer0\": \"$MOD_ID:items/$ITEM_ID\"\n\t}\n}" > $FULL_PATH
fi

# Add new tool
if [ $ITEM_TYPE == "-t" ]; then	
	FULL_PATH="$MODEL_ITEM/$ITEM_ID.json"

	# Check if item alredy exists
	if [ -e $FULL_PATH ]; then
		echo -e "The file $ITEM_ID.json alredy exists!!! \nYou almost Overwrited it!"
		exit
	fi

	# Add model json
	echo -e "{\n\t\"parent\": \"item/handheld\",\n\t\"textures\": {\n\t\t\"layer0\": \"$MOD_ID:items/$ITEM_ID\"\n\t}\n}" > $FULL_PATH
fi


# Add new block
if [ $ITEM_TYPE == "-b" ]; then
	FULL_PATH_ITEM="$MODEL_ITEM/$ITEM_ID.json"        # models/item
	FULL_PATH_BLOCK="$MODEL_ITEM_BLOCK/$ITEM_ID.json" # models/block
	FULL_PATH_STATE="$BLOCK_STATE/$ITEM_ID.json"      # blockstates

	# Check if item/block exists
	if [ -e $FULL_PATH_ITEM ] || [ -e $FULL_PATH_BLOCK ] || [ -e $FULL_PATH_STATE ]; then
		echo -e "The file $ITEM_ID.json alredy exists on some of the folders: \"models/item\", \"models/block\" or \"blockstates\"!!! \nYou almost Overwrited it!"
		exit
	fi

	# models/Item
  	echo -e "{\n\t\"parent\": \"$MOD_ID:block/$ITEM_ID\"\n}" > $FULL_PATH_ITEM
	
	# models/block
	echo -e "{\n\t\"parent\": \"block/cube_all\",\n\t\"textures\": {\n\t\t\"all\": \"$MOD_ID:blocks/$ITEM_ID\"\n\t}\n}" > $FULL_PATH_BLOCK

	# blockstates
	echo -e "{\n\t\"variants\": {\n\t\t\"normal\": { \"model\": \"$MOD_ID:$ITEM_ID\" }\n\t}\n}" > $FULL_PATH_STATE


	LANG_PREFIX="tile"
fi





# Add name to language file
echo "$LANG_PREFIX.$ITEM_ID.name=$ITEM_NAME" >> $LANG_FILE


echo -e "Item $ITEM_NAME added succesfully! \nYou may want to adjust some files!!!"



