package creativecores.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Interp;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.EmpBulletType;
import mindustry.entities.part.HaloPart;
import mindustry.gen.Sounds;
import mindustry.gen.Unit;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Layer;
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
            constructor = UnitEntity::create;
            hitSize = 10f;
            engineOffset = 10f;
            engineSize = 14f;
            parts.add(
                new HaloPart(){{
                    x = 0;
                    y = 0;
                    mirror = false;
                    hollow = true;
                    sides = 6;
                    radius = 30f;
                    stroke = 3f;
                    color = Color.valueOf("ab7bba");
                    haloRotateSpeed = 1.3f;
                    colorTo = Color.valueOf("a65fba");
                    layer = Layer.effect;
                }}
            );

            weapons.add(
                    new Weapon("unit-pod-launcher"){{
                        x = 10f;
                        y = 0;
                        mirror = true;
                        reload = 100f;
                        shootSound = Sounds.artillery;
                        bullet = new BasicBulletType(){{
                            trailLength = 10;
                            speed = 2f;
                            width = 20f;
                            height = 20f;
                            lifetime = 185f;
                            frontColor = Color.valueOf("c57cd9");
                            backColor = Color.valueOf("#8652a8");
                            trailColor = Color.valueOf("#8652a8");
                            fragBullets = 12;
                            fragAngle = 45;
                            damage = 45;
                            hitEffect = CCFx.mothershipBulletHit();

                            fragBullet = new BasicBulletType(){{
                                trailLength = 5;
                                speed = 3f;
                                width = 10f;
                                height = 10f;
                                lifetime = 250f;
                                frontColor = Color.valueOf("c57cd9");
                                backColor = Color.valueOf("#8652a8");
                                trailColor = Color.valueOf("#8652a8");
                                damage = 10;
                            }};
                        }};
                    }}
            );

            abilities.add(new ForceFieldAbility(150f, 10f, 1000f, 5 * 60f));
            abilities.add(new UnitSpawnAbility(UnitTypes.zenith, 20 * 60f, 0, 0));
            abilities.add(new UnitSpawnAbility(UnitTypes.horizon, 10 * 60f, 20, 0));
            abilities.add(new UnitSpawnAbility(UnitTypes.horizon, 10 * 60f, -20, 0));
        }
            @Override
            public void draw(Unit unit){
                super.draw(unit);
            }
        };
    }
}
