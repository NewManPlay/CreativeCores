package creativecores.content;

import arc.Core;
import creativecores.graphics.CCPal;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.TractorBeamTurret;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;

public class CCBlocks {
    public static Block
        //turret
        swarmling, colony,

        triantha
    ;

    public void load() {
        swarmling = new ItemTurret("swarmling"){{
            requirements(Category.turret, with(Items.titanium, 80, Items.silicon, 120));
            ammo(
                    Items.coal, new MissileBulletType(2.5f, 12f){{
                        width = 4f;
                        height = 6f;
                        shrinkY = 0f;
                        splashDamageRadius = 4f;
                        splashDamage = 4f * 1.5f;
                        ammoMultiplier = 4f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;

                        status = StatusEffects.burning;
                        statusDuration = 60f;
                        lifetime = 100;
                    }}
            );
            size = 1;
            reload = 34f;
            inaccuracy = 2f;
            range = 100f;
            health = 350;
            shootSound = Sounds.missile;
            limitRange(5f);
            coolant = consumeCoolant(0.21f);
        }};

        colony = new ItemTurret("colony"){{
            requirements(Category.turret, with(Items.copper, 340, Items.titanium, 120, Items.silicon, 130, Items.graphite, 210, Items.plastanium, 135, Items.thorium, 160));
            ammo(
                    Items.thorium, new MissileBulletType(3.1f, 56f){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0.1f;
                        splashDamageRadius = 20f;
                        splashDamage = 35f * 1.5f;
                        ammoMultiplier = 3.4f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;

                        status = StatusEffects.burning;
                        statusDuration = 60f;
                        lifetime = 430;
                    }},
                    Items.pyratite, new MissileBulletType(2.3f, 43f){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0.1f;
                        splashDamageRadius = 20f;
                        splashDamage = 35f * 1.5f;
                        ammoMultiplier = 3.4f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;

                        status = StatusEffects.burning;
                        statusDuration = 60f;
                        lifetime = 430;
                    }},
                    Items.blastCompound, new MissileBulletType(2.5f, 32f){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0.1f;
                        splashDamageRadius = 45f;
                        splashDamage = 65f * 3.2f;
                        makeFire = true;
                        ammoMultiplier = 3.4f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;

                        status = StatusEffects.blasted;
                        statusDuration = 60f * 2f;
                        lifetime = 430;
                    }},
                    Items.surgeAlloy, new MissileBulletType(3.7f, 34){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        splashDamageRadius = 34f;
                        splashDamage = 45f * 1.4f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;
                        ammoMultiplier = 4f;
                        lightningDamage = 16;
                        lightning = 4;
                        lightningLength = 16;
                    }}
            );
            size = 3;
            shoot = new ShootAlternate(){{
                shots = 6;
                barrels = 5;
                spread = 6f;
                shotDelay = 4f;
            }};
            reload = 32f;
            inaccuracy = 5f;
            range = 430f;
            health = 560;
            shootSound = Sounds.missile;
            limitRange(3f);
            coolant = consumeCoolant(0.32f);
        }};

        triantha = new TractorBeamTurret("triantha"){{
            requirements(Category.turret, with(Items.silicon, 450, Items.thorium, 540, Items.plastanium, 250, Items.phaseFabric, 120));

            size = 4;
            force = 21f;
            laserWidth = 1;
            scaledForce = 8f;
            range = 430f;
            damage = 17f;
            scaledHealth = 320;
            rotateSpeed = 10;
            laserColor = CCPal.mothershipGreenLight;

            consumeLiquid(Liquids.water, 10f);
        }};
    }
}
