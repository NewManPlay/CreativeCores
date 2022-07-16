package creativecores.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Interp;
import arc.math.Rand;
import arc.math.geom.Vec2;
import mindustry.entities.Effect;

import static arc.graphics.g2d.Draw.color;

public class CCFx {
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();
    public static Effect mothershipBulletHit(){
        return new Effect(40f, 50f, e -> {
            Draw.color(Color.valueOf("c57cd9"));
            Lines.stroke(e.fout(Interp.pow5In) * 15f);
            Lines.circle(e.x, e.y, 65f);

            float length = 10f + e.finpow() * 20f;
            rand.setSeed(e.id);
            for(int i = 0; i < 13; i++){
                v.trns(rand.random(360f), rand.random(length));
                float sizer = rand.random(1.3f, 3.7f);

                e.scaled(e.lifetime * rand.random(0.5f, 1f), b -> {
                    color(Color.valueOf("c57cd9"), b.fslope() * 0.93f);

                    Fill.circle(e.x + v.x, e.y + v.y, sizer + b.fslope() * 1.2f);
                });
            }
        });
    }
}
