package net.mcreator.thedeepestdepths.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.thedeepestdepths.block.BloodshroomBrainRootBlock;
import net.mcreator.thedeepestdepths.TheDeepestDepthsModElements;
import net.mcreator.thedeepestdepths.TheDeepestDepthsMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

@TheDeepestDepthsModElements.ModElement.Tag
public class AncientTomeOnBlockRightClickedProcedure extends TheDeepestDepthsModElements.ModElement {
	public AncientTomeOnBlockRightClickedProcedure(TheDeepestDepthsModElements instance) {
		super(instance, 147);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency entity for procedure AncientTomeOnBlockRightClicked!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency x for procedure AncientTomeOnBlockRightClicked!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency y for procedure AncientTomeOnBlockRightClicked!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency z for procedure AncientTomeOnBlockRightClicked!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheDeepestDepthsMod.LOGGER.warn("Failed to load dependency world for procedure AncientTomeOnBlockRightClicked!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean e = false;
		ItemStack item = ItemStack.EMPTY;
		double num = 0;
		double ye = 0;
		double xe = 0;
		double ze = 0;
		if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount()) >= 1)) {
			num = (double) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount());
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setCount((int) 1);
			item = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).copy());
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setCount((int) (num));
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
		} else if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount()) >= 1)) {
			num = (double) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount());
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).setCount((int) 1);
			item = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).copy());
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).setCount((int) (num));
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).shrink((int) 1);
		} else {
			return (true);
		}
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1), (z + 0.5), (item));
			entityToSpawn.setPickupDelay((int) 20);
			world.addEntity(entityToSpawn);
		}
		if ((new ItemStack(BloodshroomBrainRootBlock.block, (int) (1)).getItem() == (item).getItem())) {
			xe = (double) x;
			ye = (double) 256;
			ze = (double) z;
			{
				List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
						new AxisAlignedBB(x - (6 / 2d), (y + 1) - (6 / 2d), z - (6 / 2d), x + (6 / 2d), (y + 1) + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, (y + 1), z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (((entityiterator instanceof PlayerEntity) == (entityiterator instanceof ServerPlayerEntity))) {
						if (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey
								.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("the_deepest_depths:vergo_zone_dim"))))) {
							if (world instanceof ServerWorld) {
								IWorld _worldorig = world;
								world = ((ServerWorld) world).getServer().getWorld(World.OVERWORLD);
								if (world != null) {
									while ((true)) {
										if ((((world.getBlockState(new BlockPos((int) (xe), (int) (ye), (int) (ze)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) + 1), (int) (ze))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& (world.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) (ze)))
																.isSolid())))) {
											break;
										}
										ye = (double) ((ye) - 1);
										if (((ye) <= 0)) {
											xe = (double) ((xe) + (((new Random()).nextInt((int) 18 + 1)) - 9));
											ze = (double) ((ze) + (((new Random()).nextInt((int) 18 + 1)) - 9));
											ye = (double) 256;
										}
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = World.OVERWORLD;
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
									{
										Entity _ent = entityiterator;
										_ent.setPositionAndUpdate((x + 0.5), (ye), (z + 0.5));
										if (_ent instanceof ServerPlayerEntity) {
											((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 0.5), (ye), (z + 0.5), _ent.rotationYaw,
													_ent.rotationPitch, Collections.emptySet());
										}
									}
								}
								world = _worldorig;
							}
						} else {
							if (world instanceof ServerWorld) {
								IWorld _worldorig = world;
								world = ((ServerWorld) world).getServer().getWorld(
										RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("the_deepest_depths:vergo_zone_dim")));
								if (world != null) {
									while ((true)) {
										if ((((world.getBlockState(new BlockPos((int) (xe), (int) (ye), (int) (ze)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) + 1), (int) (ze))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) (ze))).isSolid())
																&& (!((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) (ze))))
																		.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))))) {
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
													RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
															new ResourceLocation("the_deepest_depths:vergo_zone_dim"));
													ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
													if (nextWorld != null) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
														((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
														for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
															((ServerPlayerEntity) _ent).connection
																	.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
														}
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
													}
												}
											}
											{
												Entity _ent = entityiterator;
												_ent.setPositionAndUpdate(((xe) + 0.5), (ye), ((ze) + 0.5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(((xe) + 0.5), (ye), ((ze) + 0.5),
															_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
												}
											}
											break;
										}
										if ((((world.getBlockState(new BlockPos((int) ((xe) - 1), (int) (ye), (int) (ze)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) ((xe) - 1), (int) ((ye) + 1), (int) (ze))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) ((xe) - 1), (int) ((ye) - 1), (int) (ze)))
																.isSolid())
																&& (!((world
																		.getBlockState(new BlockPos((int) ((xe) - 1), (int) ((ye) - 1), (int) (ze))))
																				.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))))) {
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
													RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
															new ResourceLocation("the_deepest_depths:vergo_zone_dim"));
													ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
													if (nextWorld != null) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
														((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
														for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
															((ServerPlayerEntity) _ent).connection
																	.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
														}
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
													}
												}
											}
											{
												Entity _ent = entityiterator;
												_ent.setPositionAndUpdate(((xe) - 0.5), (ye), ((ze) + 0.5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(((xe) - 0.5), (ye), ((ze) + 0.5),
															_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
												}
											}
											break;
										}
										if ((((world.getBlockState(new BlockPos((int) ((xe) + 1), (int) (ye), (int) (ze)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) ((xe) + 1), (int) ((ye) + 1), (int) (ze))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) ((xe) + 1), (int) ((ye) - 1), (int) (ze)))
																.isSolid())
																&& (!((world
																		.getBlockState(new BlockPos((int) ((xe) + 1), (int) ((ye) - 1), (int) (ze))))
																				.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))))) {
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
													RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
															new ResourceLocation("the_deepest_depths:vergo_zone_dim"));
													ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
													if (nextWorld != null) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
														((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
														for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
															((ServerPlayerEntity) _ent).connection
																	.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
														}
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
													}
												}
											}
											{
												Entity _ent = entityiterator;
												_ent.setPositionAndUpdate(((xe) + 1.5), (ye), ((ze) + 0.5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(((xe) + 1.5), (ye), ((ze) + 0.5),
															_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
												}
											}
											break;
										}
										if ((((world.getBlockState(new BlockPos((int) (xe), (int) (ye), (int) ((ze) + 1)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) + 1), (int) ((ze) + 1))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) ((ze) + 1)))
																.isSolid())
																&& (!((world
																		.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) ((ze) + 1))))
																				.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))))) {
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
													RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
															new ResourceLocation("the_deepest_depths:vergo_zone_dim"));
													ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
													if (nextWorld != null) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
														((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
														for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
															((ServerPlayerEntity) _ent).connection
																	.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
														}
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
													}
												}
											}
											{
												Entity _ent = entityiterator;
												_ent.setPositionAndUpdate(((xe) + 0.5), (ye), ((ze) + 1.5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(((xe) + 0.5), (ye), ((ze) + 1.5),
															_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
												}
											}
											break;
										}
										if ((((world.getBlockState(new BlockPos((int) (xe), (int) (ye), (int) ((ze) - 1)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) + 1), (int) ((ze) - 1))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) ((ze) - 1)))
																.isSolid())
																&& (!((world
																		.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) ((ze) - 1))))
																				.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))))) {
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
													RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
															new ResourceLocation("the_deepest_depths:vergo_zone_dim"));
													ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
													if (nextWorld != null) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
														((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
														for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
															((ServerPlayerEntity) _ent).connection
																	.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
														}
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
													}
												}
											}
											{
												Entity _ent = entityiterator;
												_ent.setPositionAndUpdate(((xe) + 0.5), (ye), ((ze) - 0.5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(((xe) + 0.5), (ye), ((ze) - 0.5),
															_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
												}
											}
											break;
										}
										ye = (double) ((ye) - 1);
										if (((ye) <= 0)) {
											ye = (double) 127;
											xe = (double) ((xe) + (((new Random()).nextInt((int) 18 + 1)) - 9));
											ze = (double) ((ze) + (((new Random()).nextInt((int) 18 + 1)) - 9));
										}
									}
								}
								world = _worldorig;
							}
						}
					}
				}
			}
		}
		if ((new ItemStack(Items.ROTTEN_FLESH, (int) (1)).getItem() == (item).getItem())) {
			xe = (double) x;
			ye = (double) 256;
			ze = (double) z;
			{
				List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
						new AxisAlignedBB(x - (6 / 2d), (y + 1) - (6 / 2d), z - (6 / 2d), x + (6 / 2d), (y + 1) + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, (y + 1), z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (((entityiterator instanceof PlayerEntity) == (entityiterator instanceof ServerPlayerEntity))) {
						if (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey
								.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("the_deepest_depths:blood_world"))))) {
							if (world instanceof ServerWorld) {
								IWorld _worldorig = world;
								world = ((ServerWorld) world).getServer().getWorld(World.OVERWORLD);
								if (world != null) {
									while ((true)) {
										if ((((world.getBlockState(new BlockPos((int) (xe), (int) (ye), (int) (ze)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) + 1), (int) (ze))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& (world.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) (ze)))
																.isSolid())))) {
											break;
										}
										ye = (double) ((ye) - 1);
										if (((ye) <= 0)) {
											xe = (double) ((xe) + (((new Random()).nextInt((int) 18 + 1)) - 9));
											ze = (double) ((ze) + (((new Random()).nextInt((int) 18 + 1)) - 9));
											ye = (double) 256;
										}
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = World.OVERWORLD;
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
									{
										Entity _ent = entityiterator;
										_ent.setPositionAndUpdate((x + 0.5), (ye), (z + 0.5));
										if (_ent instanceof ServerPlayerEntity) {
											((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 0.5), (ye), (z + 0.5), _ent.rotationYaw,
													_ent.rotationPitch, Collections.emptySet());
										}
									}
								}
								world = _worldorig;
							}
						} else {
							if (world instanceof ServerWorld) {
								IWorld _worldorig = world;
								world = ((ServerWorld) world).getServer().getWorld(
										RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("the_deepest_depths:blood_world")));
								if (world != null) {
									while ((true)) {
										if ((((world.getBlockState(new BlockPos((int) (xe), (int) (ye), (int) (ze)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) + 1), (int) (ze))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) (ze))).isSolid())
																&& (!((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) (ze))))
																		.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))))) {
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
													RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
															new ResourceLocation("the_deepest_depths:blood_world"));
													ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
													if (nextWorld != null) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
														((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
														for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
															((ServerPlayerEntity) _ent).connection
																	.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
														}
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
													}
												}
											}
											{
												Entity _ent = entityiterator;
												_ent.setPositionAndUpdate(((xe) + 0.5), (ye), ((ze) + 0.5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(((xe) + 0.5), (ye), ((ze) + 0.5),
															_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
												}
											}
											break;
										}
										if ((((world.getBlockState(new BlockPos((int) ((xe) - 1), (int) (ye), (int) (ze)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) ((xe) - 1), (int) ((ye) + 1), (int) (ze))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) ((xe) - 1), (int) ((ye) - 1), (int) (ze)))
																.isSolid())
																&& (!((world
																		.getBlockState(new BlockPos((int) ((xe) - 1), (int) ((ye) - 1), (int) (ze))))
																				.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))))) {
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
													RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
															new ResourceLocation("the_deepest_depths:blood_world"));
													ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
													if (nextWorld != null) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
														((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
														for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
															((ServerPlayerEntity) _ent).connection
																	.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
														}
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
													}
												}
											}
											{
												Entity _ent = entityiterator;
												_ent.setPositionAndUpdate(((xe) - 0.5), (ye), ((ze) + 0.5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(((xe) - 0.5), (ye), ((ze) + 0.5),
															_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
												}
											}
											break;
										}
										if ((((world.getBlockState(new BlockPos((int) ((xe) + 1), (int) (ye), (int) (ze)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) ((xe) + 1), (int) ((ye) + 1), (int) (ze))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) ((xe) + 1), (int) ((ye) - 1), (int) (ze)))
																.isSolid())
																&& (!((world
																		.getBlockState(new BlockPos((int) ((xe) + 1), (int) ((ye) - 1), (int) (ze))))
																				.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))))) {
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
													RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
															new ResourceLocation("the_deepest_depths:blood_world"));
													ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
													if (nextWorld != null) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
														((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
														for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
															((ServerPlayerEntity) _ent).connection
																	.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
														}
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
													}
												}
											}
											{
												Entity _ent = entityiterator;
												_ent.setPositionAndUpdate(((xe) + 1.5), (ye), ((ze) + 0.5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(((xe) + 1.5), (ye), ((ze) + 0.5),
															_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
												}
											}
											break;
										}
										if ((((world.getBlockState(new BlockPos((int) (xe), (int) (ye), (int) ((ze) + 1)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) + 1), (int) ((ze) + 1))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) ((ze) + 1)))
																.isSolid())
																&& (!((world
																		.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) ((ze) + 1))))
																				.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))))) {
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
													RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
															new ResourceLocation("the_deepest_depths:blood_world"));
													ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
													if (nextWorld != null) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
														((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
														for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
															((ServerPlayerEntity) _ent).connection
																	.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
														}
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
													}
												}
											}
											{
												Entity _ent = entityiterator;
												_ent.setPositionAndUpdate(((xe) + 0.5), (ye), ((ze) + 1.5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(((xe) + 0.5), (ye), ((ze) + 1.5),
															_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
												}
											}
											break;
										}
										if ((((world.getBlockState(new BlockPos((int) (xe), (int) (ye), (int) ((ze) - 1)))).getBlock() == Blocks.AIR
												.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) + 1), (int) ((ze) - 1))))
														.getBlock() == Blocks.AIR.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) ((ze) - 1)))
																.isSolid())
																&& (!((world
																		.getBlockState(new BlockPos((int) (xe), (int) ((ye) - 1), (int) ((ze) - 1))))
																				.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))))) {
											{
												Entity _ent = entityiterator;
												if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
													RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
															new ResourceLocation("the_deepest_depths:blood_world"));
													ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
													if (nextWorld != null) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
														((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
														for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
															((ServerPlayerEntity) _ent).connection
																	.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
														}
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
													}
												}
											}
											{
												Entity _ent = entityiterator;
												_ent.setPositionAndUpdate(((xe) + 0.5), (ye), ((ze) - 0.5));
												if (_ent instanceof ServerPlayerEntity) {
													((ServerPlayerEntity) _ent).connection.setPlayerLocation(((xe) + 0.5), (ye), ((ze) - 0.5),
															_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
												}
											}
											break;
										}
										ye = (double) ((ye) - 1);
										if (((ye) <= 0)) {
											ye = (double) 127;
											xe = (double) ((xe) + (((new Random()).nextInt((int) 18 + 1)) - 9));
											ze = (double) ((ze) + (((new Random()).nextInt((int) 18 + 1)) - 9));
										}
									}
								}
								world = _worldorig;
							}
						}
					}
				}
			}
		}
		return (true);
	}
}
