package com.atticl.items;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class ModLootTables {
    private static final ResourceKey<LootTable> SKELETON_LOOT_TABLE_ID = EntityType.SKELETON.getDefaultLootTable().orElseThrow();
    private static final ResourceKey<LootTable> COW_LOOT_TABLE_ID = EntityType.COW.getDefaultLootTable().orElseThrow();
    private static final ResourceKey<LootTable> PIG_LOOT_TABLE_ID = EntityType.PIG.getDefaultLootTable().orElseThrow();
    private static final ResourceKey<LootTable> SHEEP_LOOT_TABLE_ID = EntityType.SHEEP.getDefaultLootTable().orElseThrow();

    public static void initialize() {
        LootTableEvents.MODIFY.register((id, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && SKELETON_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .when(LootItemRandomChanceCondition.randomChance(0.75f))
                        .add(LootItem.lootTableItem(ModItems.BONE_SHARD));
        
                tableBuilder.pool(poolBuilder.build());
            }

            if (source.isBuiltin() && (COW_LOOT_TABLE_ID.equals(id) || PIG_LOOT_TABLE_ID.equals(id) || SHEEP_LOOT_TABLE_ID.equals(id))) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .when(LootItemRandomChanceCondition.randomChance(0.5f))
                        .add(LootItem.lootTableItem(ModItems.HIDE_SCRAP));
        
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }    
}
