#!/bin/bash

CORRECT_USAGE="Correct Usage: new_item (-b | -i | -t) item_id \"Item Name\""

MOD_ID="wingedhoof"
RESOURCES="src/main/resources/assets/wingedhoof"

MODEL_ITEM="$RESOURCES/models/item"
MODEL_ITEM_BLOCK="$RESOURCES/models/block"
BLOCK_STATE="$RESOURCES/blockstates"

LANG_FILE="$RESOURCES/lang/en_us.lang"
LANG_PREFIX="item"

ITEM_TYPE="$1"
ITEM_ID="$2"
ITEM_NAME="$3"

# Check if usage is valid
if [ $ITEM_TYPE != "-i" ] && [ $ITEM_TYPE != "-b" ] && [ $ITEM_TYPE != "-t" ]; then
	echo -e "Invalid Usage: -i or -b expected as argument \n$CORRECT_USAGE"
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