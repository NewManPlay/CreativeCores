package creativecores.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Interp;
import creativecores.graphics.CCPal;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.EmpBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.part.HaloPart;
import mindustry.gen.Sounds;
import mindustry.gen.Unit;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;

public class CCUnitTypes {
    public static UnitType
        //boss
        mothership
    ;

    public void load(){
        mothership = new UnitType("mothership"){{
            health = 65000;
            armor = 50;
            speed = 0.32f;
            flying = true;
            lowAltitude = true;
            constructor = UnitEntity::create;
            hitSize = 10f;
            range = 200;
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
                    new Weapon("fission-gun"){{
                        x = 0f;
                        y = 0f;
                        mirror = false;
                        reload = 160f;
                        shootSound = Sounds.artillery;
                        top = true;
                        bullet = new MissileBulletType(5, 200){{
                            trailLength = 40;
                            trailWidth = 6f;
                            speed = 2f;
                            width = 40f;
                            height = 40f;
                            lifetime = 185f;
                            frontColor = CCPal.mothershipGreenLight;
                            backColor = CCPal.mothershipGreen;
                            trailColor = CCPal.mothershipGreen;
                            fragBullets = 10;
                            hitEffect = CCFx.mothershipHit;
                            hitSize = 30f;

                            fragBullet = new MissileBulletType(4, 20){{
                                trailLength = 5;
                                speed = 6f;
                                width = 30f;
                                height = 30f;
                                lifetime = 100f;
                                frontColor = CCPal.mothershipGreenLight;
                                backColor = CCPal.mothershipGreen;
                                trailColor = CCPal.mothershipGreen;
                                fragBullets =5;
                                hitSize = 30f;
                                fragBullet = new MissileBulletType(3, 10){{
                                    trailLength = 3;
                                    speed = 3f;
                                    width = 20f;
                                    height = 20f;
                                    lifetime = 80f;
                                    frontColor = CCPal.mothershipGreenLight;
                                    backColor = CCPal.mothershipGreen;
                                    trailColor = CCPal.mothershipGreen;
                                    hitSize = 30f;
                                    fragBullets = 2;

                                    fragBullet = new MissileBulletType(3, 5){{
                                        trailLength = 3;
                                        speed = 3f;
                                        width = 10f;
                                        height = 10f;
                                        lifetime = 80f;
                                        frontColor = CCPal.mothershipGreenLight;
                                        backColor = CCPal.mothershipGreen;
                                        trailColor = CCPal.mothershipGreen;
                                    }};
                                }};
                            }};
                        }};
                    }}
            );

            abilities.add(new ForceFieldAbility(150f, 10f, 1000f, 5 * 60f));
            abilities.add(new UnitSpawnAbility(UnitTypes.zenith, 20 * 60f, 0, -12));
            abilities.add(new UnitSpawnAbility(UnitTypes.horizon, 10 * 60f, 40, 0));
            abilities.add(new UnitSpawnAbility(UnitTypes.horizon, 10 * 60f, -40, 0));
        }};
    }
}
