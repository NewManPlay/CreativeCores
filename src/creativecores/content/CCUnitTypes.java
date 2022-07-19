package creativecores.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Interp;
import creativecores.graphics.CCPal;
import mindustry.content.Fx;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.EmpBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.part.HaloPart;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;

public class CCUnitTypes {
    public static UnitType
        //boss
        mothership, sprout, spring
    ;

    public void load(){
        sprout = new UnitType("sprout"){{
            health = 550;
            armor = 1;
            speed = 1.2f;
            drag = 0.08f;
            accel = 0.04f;
            range = 55f;
            constructor = LegsUnit::create;
            hitSize = 3f;

            weapons.add(
                    new Weapon("sprout-cannon"){{
                        x = 0;
                        y = 0;
                        top = false;
                        reload = 45f;
                        bullet = new BasicBulletType(4.3f, 20f){{
                            frontColor = CCPal.mothershipGreenLight;
                            backColor = CCPal.mothershipGreen;
                            trailColor = CCPal.mothershipGreen;
                            sprite = "circle-bullet";
                            trailEffect = Fx.heal;
                            trailLength = 10;
                            trailWidth = 4;
                            hitSize = 5f;

                            height = 15f;
                            width = 15f;
                        }};
                    }}
            );

            legCount = 8;
            legLength = 12;
            legGroupSize = 4;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -3;
            legBaseOffset = 2.4f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legSpeed = 2;
            legLengthScl = 0.95f;
            legForwardScl = 0.7f;
            legMoveSpace = 1;
            hovering = true;
            stepShake = 0;
            rippleScale = 0.1f;
        }};
        spring = new UnitType("spring"){{
            health = 850;
            armor = 5;
            speed = 0.86f;
            drag = 0.08f;
            accel = 0.04f;
            legMaxLength = 2;
            legBaseOffset = 3f;
            range = 80f;
            constructor = MechUnit::create;
            hitSize = 7f;

            weapons.add(
                    new Weapon("creativecores-spring-cannon"){{
                        x = 13;
                        y = 0;
                        top = true;
                        reload = 45f;
                        mirror = true;
                        bullet = new BasicBulletType(4.3f, 5f){{
                            frontColor = CCPal.mothershipGreenLight;
                            backColor = CCPal.mothershipGreen;
                            trailColor = CCPal.mothershipGreen;
                            trailEffect = Fx.heal;
                            sprite = "circle-bullet";
                            trailLength = 5;
                            trailWidth = 2;
                            hitSize = 5f;
                            reload = 6f;

                            height = 10f;
                            width = 10f;
                        }};
                    }}
            );
        }};
        mothership = new UnitType("mothership"){{
            health = 65000;
            armor = 50;
            speed = 0.4f;
            flying = true;
            lowAltitude = true;
            constructor = UnitEntity::create;
            hitSize = 10f;
            range = 200;
            rotateSpeed = 0.5f;
            engineOffset = 10f;
            engineSize = 14f;
            parts.add(
                new HaloPart(){{
                    x = 0;
                    y = 0;
                    mirror = false;
                    hollow = true;
                    sides = 6;
                    shapes = 5;
                    radius = 20f;
                    stroke = 3f;
                    color = CCPal.mothershipGreen;
                    haloRotateSpeed = 1.3f;
                    colorTo = CCPal.mothershipGreenLight;
                    layer = Layer.effect;
                }}
            );


            weapons.add(
                    new Weapon("creativecores-fission-gun"){{
                        x = 35f;
                        y = -15f;
                        mirror = true;
                        flipSprite = true;
                        reload = 250f;
                        shootSound = Sounds.artillery;
                        top = true;
                        bullet = new MissileBulletType(10f, 400f){{
                            trailLength = 100;
                            trailWidth = 10f;
                            sprite = "circle-bullet";
                            width = 40f;
                            height = 40f;
                            lifetime = 50f;
                            frontColor = CCPal.mothershipGreenLight;
                            backColor = CCPal.mothershipGreen;
                            trailColor = CCPal.mothershipGreen;
                            fragBullets = 10;
                            hitEffect = CCFx.mothershipHit;
                            hitSize = 30f;
                            fragRandomSpread = 65;
                            weaveScale = 2f;
                            weaveMag = 10f;
                            pierce = true;

                            fragBullet = new MissileBulletType(7, 200){{
                                trailLength = 5;
                                trailEffect = Fx.heal;
                                sprite = "circle-bullet";
                                speed = 6f;
                                width = 30f;
                                height = 30f;
                                lifetime = 100f;
                                frontColor = CCPal.mothershipGreenLight;
                                backColor = CCPal.mothershipGreen;
                                trailColor = CCPal.mothershipGreen;
                                fragBullets =5;
                                hitSize = 30f;
                                fragRandomSpread = 65;
                                weaveScale = 2f;
                                weaveMag = 10f;
                                pierce = true;
                                fragBullet = new MissileBulletType(8, 130){{
                                    trailLength = 3;
                                    trailEffect = Fx.heal;
                                    sprite = "circle-bullet";
                                    speed = 3f;
                                    width = 20f;
                                    height = 20f;
                                    lifetime = 80f;
                                    frontColor = CCPal.mothershipGreenLight;
                                    backColor = CCPal.mothershipGreen;
                                    trailColor = CCPal.mothershipGreen;
                                    hitSize = 30f;
                                    fragBullets = 2;
                                    fragRandomSpread = 65;
                                    weaveScale = 2f;
                                    weaveMag = 10f;
                                    pierce = true;

                                    fragBullet = new MissileBulletType(7, 100){{
                                        trailLength = 3;
                                        trailEffect = Fx.heal;
                                        sprite = "circle-bullet";
                                        speed = 3f;
                                        width = 10f;
                                        height = 10f;
                                        lifetime = 80f;
                                        frontColor = CCPal.mothershipGreenLight;
                                        backColor = CCPal.mothershipGreen;
                                        trailColor = CCPal.mothershipGreen;
                                        weaveScale = 2f;
                                        weaveMag = 10f;
                                        fragBullets = 4;
                                        pierce = true;

                                        fragBullet = new MissileBulletType(9, 50){{
                                            trailLength = 3;
                                            trailEffect = Fx.heal;
                                            sprite = "circle-bullet";
                                            speed = 3f;
                                            width = 10f;
                                            height = 10f;
                                            lifetime = 80f;
                                            frontColor = CCPal.mothershipGreenLight;
                                            backColor = CCPal.mothershipGreen;
                                            trailColor = CCPal.mothershipGreen;
                                            weaveScale = 2f;
                                            weaveMag = 10f;
                                            pierce = true;
                                        }};
                                    }};
                                }};
                            }};
                        }};
                    }}
            );

            abilities.add(new ForceFieldAbility(150f, 10f, 1000f, 5 * 60f));
            abilities.add(new UnitSpawnAbility(CCUnitTypes.spring, 20 * 60f, 0, -12));
            abilities.add(new UnitSpawnAbility(CCUnitTypes.sprout, 10 * 60f, 40, 0));
            abilities.add(new UnitSpawnAbility(CCUnitTypes.sprout, 10 * 60f, -40, 0));
        }};
    }
}
