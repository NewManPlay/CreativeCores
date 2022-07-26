package creativecores.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Interp;
import creativecores.graphics.CCPal;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.part.HaloPart;
import mindustry.entities.part.ShapePart;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;

import javax.print.attribute.HashAttributeSet;

public class CCUnitTypes {
    public static UnitType
        //motherhsip
        mothership, sprout, spring,

        //inferno
        inferno
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
                        top = false;
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
            speed = 0.3f;
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
                    x = 40;
                    y = 0;
                    mirror = true;
                    hollow = true;
                    sides = 6;
                    shapes = 5;
                    radius = 10f;
                    stroke = 3f;
                    color = CCPal.mothershipGreen;
                    haloRotateSpeed = 1.3f;
                    colorTo = CCPal.mothershipGreenLight;
                    layer = Layer.effect;
                }}

              );

            weapons.add(
                    new Weapon("creativecores-fission-gun"){{
                        x = 40f;
                        y = 0f;
                        mirror = true;
                        flipSprite = true;
                        reload = 250f;
                        shootSound = Sounds.artillery;
                        top = true;
                        bullet = new MissileBulletType(10f, 600f){{
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

                            fragBullet = new MissileBulletType(7, 160){{
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
                                fragBullet = new MissileBulletType(8, 50){{
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

                                    fragBullet = new MissileBulletType(7, 20){{
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
                                    }};
                                }};
                            }};
                        }};
                    }}
            );

            abilities.add(new ForceFieldAbility(150f, 10f, 1000f, 5 * 60f));
            abilities.add(new UnitSpawnAbility(CCUnitTypes.spring, 20 * 60f, 0, -12));
            abilities.add(new UnitSpawnAbility(CCUnitTypes.sprout, 10 * 60f, 40, -20));
            abilities.add(new UnitSpawnAbility(CCUnitTypes.sprout, 10 * 60f, -40, -20));
        }};

        inferno = new UnitType("inferno"){{
            health = 45700;
            armor = 20;
            speed = 0.4f;
            drag = 0.06f;
            accel = 0.04f;
            legMaxLength = 2;
            legSpeed = 0.8f;
            legBaseOffset = 3f;
            mechFrontSway = 1f;
            mechSideSway = 2.6f;
            immunities.add(StatusEffects.burning);
            constructor = MechUnit::create;
            hitSize = 7f;
            rotateSpeed = 0.65f;

            parts.add(
                  new HaloPart(){{
                      x = 0;
                      y = 0;
                      mirror = false;
                      hollow = true;
                      sides = 4;
                      shapes = 3;
                      radius = 16f;
                      stroke = 5f;
                      color = CCPal.infernoFlameLight;
                      haloRotateSpeed = 0.8f;
                      colorTo = CCPal.infernoFlameLight;
                      layer = Layer.effect;
                  }}
            );

            weapons.add(
                    new Weapon("creativecores-inferno-melter"){{
                        x = 75;
                        y = 0;
                        top = false;
                        reload = 5f;
                        mirror = true;
                        range = 45;
                        alternate = false;
                        bullet = new BasicBulletType(6f, 160f){{
                            collidesAir = true;
                            shootY = 45;
                            width = 0.1f;
                            height = 0.1f;
                            hitSize = 10;
                            shootEffect = new ParticleEffect(){{
                                particles = 40;
                                sizeFrom = 9;
                                sizeTo = 1;
                                length = 290;
                                lifetime = 60;
                                interp = Interp.circleOut;
                                colorFrom = CCPal.infernoFlame;
                                colorTo = CCPal.infernoFlameLight;
                                cone = 16;
                            }};
                            hitEffect = new ParticleEffect(){{
                                particles = 10;
                                sizeFrom = 0;
                                sizeTo = 1;
                                length = 20;
                                lifetime = 22;
                                interp = Interp.circleOut;
                                colorFrom = CCPal.infernoFlame;
                                colorTo = CCPal.infernoFlameLight;
                                cone = 16;
                            }};
                            despawnEffect = Fx.none;
                            lifetime = 40f;
                            hittable = false;
                            reflectable = false;
                            pierce = true;
                            incendAmount = 5;
                        }};
                    }},

                    new Weapon("creativecores-inferno-cutter"){{
                        x = 0;
                        y = 45;
                        top = false;
                        reload = 650;
                        mirror = false;
                        range = 360;
                        shootSound = Sounds.laserblast;
                        chargeSound = Sounds.lasercharge;
                        soundPitchMin = 1f;
                        shake = 20f;
                        shootY = 0f;
                        recoil = 0f;

                        cooldownTime = 350f;

                        shootStatusDuration = 60f * 3f;
                        shootStatus = StatusEffects.unmoving;
                        shoot.firstShotDelay = 60 * 2f;
                        parentizeEffects = true;
                        bullet = new LaserBulletType(){{
                            length = 540f;
                            damage = 640f;
                            width = 80f;

                            lifetime = 100f;

                            lightningSpacing = 35f;
                            lightningLength = 5;
                            lightningDelay = 1.1f;
                            lightningLengthRand = 15;
                            lightningDamage = 60;
                            lightningAngleRand = 40f;
                            largeHit = true;
                            lightColor = lightningColor = CCPal.infernoFlameLight;

                            chargeEffect = CCFx.infernoLaserShoot;

                            sideAngle = 15f;
                            sideWidth = 0f;
                            sideLength = 0f;
                            colors = new Color[]{CCPal.infernoFlameLight.cpy().a(0.4f), CCPal.infernoFlameLight, Color.white};
                        }};
                    }},

                    new Weapon("inferno-launcher"){{
                        x = 30;
                        y = 45;
                        mirror = true;
                        top = false;
                        reload = 45;
                        bullet = new MissileBulletType(3, 100){{
                            sprite = "creativecores-inferno-missile";
                            height = 20;
                            width = 14;
                            trailLength = 10;
                            trailWidth = 5;
                            lifetime = 400;
                            trailColor = CCPal.infernoFlameLight;
                            backColor = CCPal.infernoFlame;
                            frontColor = CCPal.infernoFlameLight;
                        }};
                    }}
            );
        }};
    }
}
