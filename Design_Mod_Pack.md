# Minecrawl - A Minecraft Dungeon Crawler

Minecrawl has two main modes, Rogue-like and Rogue-lite.

Both modes are played in Adventure Mode and are multiplayer compatible.

The player (and his team) battle their way through a series of levels. Each level has a main area that contains a challenge.
When the challenge is mastered, a door to the reward room opens. The reward room contains a loot container and one or more exits.
The exits lead to the next level.

Some levels contain special events, for example a boss fight or a NPC. They offer a unique challenge and/or reward.

## Differences Rogue-like vs Rogue-lite

### Rogue-like

The Rogue-like mode is easy to understand. The player goes from room to room until they die.
When the player dies, all advancements, found items and other achievements are reset and the player can begin again.

### Rogue-lite

The Rogue-lite mode is a bit more complicated. The player starts in a special level. This level is shared with all other players and acts as a "hub".
It gives access to a variety of different "dungeons".

Each dungeon contains a series of levels, just like the Rogue-like mode.
The dungeons have a pre-determined end, however. When the player reaches this end, they return to the "hub".
They keep all advancements, found items and other achievements.

If the player has collected the correct items / unlocked the correct advancements, they can improve the "hub" with permanent unlocks.

These unlocks give the players an advantage in future dungeon runs. They could give access to item storage, provide buffs or allow crafting of items.

The Rogue-lite mode can be customized in multiple ways.

### Rogue-lite mode customizations

Several aspects of the Rogue-lite mode can be tweaked by the player/server owner.

What happens when a player dies? Do they keep their items/advancements?\
Maybe they have to start over like in the Rogue-like mode, with the difference that they might have an advantage, when they built up the hub.

How exactly do the permanent unlocks work?
Does the hub change its appearance? On a server with many people this might not be a good solution.
Each player could get access to a personal hub/house, that they can upgrade.

Some areas of the hub could allow players to build their own creations.
This could be in their own private hub or maybe the hub has designated building zones.

## Dungeon Crawling

Regardless of Rogue-like or lite, the core gameplay stays the same: Fighting monsters, solving puzzles and looting precious items.


### Loot

Players in Minecrawl can equip items in more slots than vanilla Minecraft.

In addition to the head, chest, legs and feet slots, there are several new ones: belt, shoulder, necklace, glove and 2 ring slots. Potentially up to 8 spell slots.
Also a dedicated main hand slot and a set of alternative hand slots.

With this many slots, players have a lot of possibilities to make a build that suits their play style.
On the other hand, if items in Minecrawl were as powerful as in other mod packs, the players would become op very fast.

That is the reason why items are generally less complex. Most items have one attribute modifier.
With increasing rarity comes more power of course, so the rarest items can still be quite powerful on their own.

But the real fun (at least to me), comes when the player can experiment with their build and potentially discover powerful synergies between their items.

### Item Upgrades

Items are ideally designed in a way that no item "replaces" another item. 
An upgraded item should be more powerful than a non-upgraded item, but items of the same upgrade level should be relatively even.
This means also that an item that is good in sítuation A and bad in situation B is as good as an item that is bad in sítuation A and good in situation B.

Every item found/looted is of common rarity. If an item is inherently more powerful because of its design, it should be more difficult to find.

> BUT, every item should be loot-able in the first level

Every item can be crafted with another copy of itself into the uncommon version. Two uncommon versions of the same item can be crafted into a rare version
and two rare items can be crafted into the epic variant.\
This process requires an additional item, an "upgrade token", for each rarity another one.
They are not as common of a drop as other items

Each version increases the attribute bonus, but does not add new bonuses. This makes finding duplicate items still exciting.

Upgrading items drops slotted enchantment runes.

Upgrading is done at work stations / by NPCs. They are accessed by upgrading the hub / found in special rooms.

#### Enchanting

Enchanting is not completely gone, but it is heavily modified and has almost no resemblance to vanillas system. It is inspired by games like Torchlight 1 or 2.
Enchanting is done via work stations or NPCs. They are accessed by upgrading the hub / found in special rooms.

Each item has a number of enchantment slots, which limit the number of enchantments on the item.
The amount of enchantment slots is determined by the level of the item. Common item has 1 slot, epic item has 4 slots.

> When the amount of slots is limited to 2, the item name could be modified depending on the enchantments.
> "enchantment_1_prefix" + "item_name" + "enchantment_2_suffix"
> enchantment levels have different pre/suffixes, see PoE
> could maybe work with 4 slots
> "enchantment_1_prefix_1" + "enchantment_2_prefix_2" + "item_name" + "enchantment_3_suffix_1" + "enchantment_4_suffix_2"
> the order of enchantments on an item is purely cosmetic

Each enchantment has a corresponding item/token/rune, basically the equivalent to the Enchanted Book in vanilla.
A token/rune only holds one enchantment, but it can come in multiple levels.

There are two different ways how the player can modify the enchantments on an item: Enchanting and Disenchanting

The enchanting screen offers multiple options to the player.
- add a random enchantment (to an empty slot)
- upgrade an enchantment (with a matching enchantment token)

There could also be a way for players to combine two identical tokens or runes into one of higher level.
Maybe a separate NPC.

The disenchanting screen also offers multiple options to the player.
- remove a (random) enchantment
- extract an enchantment (as a token), the item is destroyed

(Dis)Enchantment screen providers can have a level. This level may influence which or how many options the player has.

(Dis)Enchantment screen providers can have a limited amount of uses. This is mainly relevant for the Rogue-like mode.
Player build work stations or hub NPCs don't have a limit.
Maybe hub NPCs take an additional cost
Coins?

Maybe one token is "responsible" for multiple enchantments, depending on teh item it is slotted in.
"Fire rune" in weapon: + Fire Damage
"Fire rune" in armor: + Fire Resistance

Enchantments are mostly attribute modifier providers.
Examples:
+X Fire Damage
+X Amount of Dodge Rolls
+X Health

### Item Merging

An alternative to enchanting (having both would be too much I think), inspired heavily by the game "Into the Necrovale".
Basically a way for two items to be merged into one. The result would have the combined stats (maybe the average).

Item Melding is implemented using a item component.
The component has these components:
int maxMeldedItemsAmount,
List<ItemStack> meldedItems,
optional item tag, which determines what items can be melded into the stack

Melding an item into another stack is only possible if the item either has no meldingComponent or its meldingComponent.list is empty

itemStacks with the meldedComponent take the attribute modifiers from the melded itemStacks and add them to their own
when multiple attribute modifiers with the same id and the same operation are present, the average value of them is used

#### Unlocking Merging

Level 1: Rings
Level 2: Gloves, Necklaces
Level 3: Belts, Shoulders
Level 4: Boots, Leggings
Level 5: Chests, Hats
Level 6: Weapons (Main and Offhand)

## Attributes

"Status effects you inflict deal more damage" use levels, maybe a chance to inflict next level, but the next level is much more powerful

"status effects you inflict, spread" inflict another effect that spreads and also inflicts the other effect
    how does the spreading effect know, which attributes the spread effect should have? 