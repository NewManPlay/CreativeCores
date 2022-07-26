package creativecores.content;


import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import creativecores.graphics.CCPal;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;

import javax.sound.sampled.Line;
import java.util.Random;

import static arc.graphics.g2d.Draw.alpha;
import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;

public class CCFx {
    public static final Effect

    mothershipHit = new Effect(40f, 100f, e -> {
        color(CCPal.mothershipGreenLight);
        stroke(e.fout() * 3f);
        float circleRad = 4f + e.finpow() * 100f;
        Lines.circle(e.x, e.y, circleRad * 3);

        color(CCPal.mothershipGreenLight);
        for(int i = 0; i < 8; i++){
            Drawf.tri(e.x, e.y, 10f, 200f * e.fout(), i*45);
        }

        color();
        for(int i = 0; i < 8; i++){
            Drawf.tri(e.x, e.y, 6f, 40f * e.fout(), i*45);
        }

        Drawf.light(e.x, e.y, circleRad * 1.6f, CCPal.mothershipGreenLight, e.fout());
    }),

    infernoLaserShoot = new Effect(60 * 3, 100f, e -> {
        color(CCPal.infernoFlameLight);
        Lines.stroke(e.fout() * 10);

        Lines.circle(e.x, e.y, 10f + e.fout(Interp.bounceIn) * 100);
        randLenVectors(e.id, 20, 40f * e.fout(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fin() * 10f);
            Drawf.light(e.x + x, e.y + y, e.fin() * 15f, CCPal.infernoFlameLight, 0.7f);
        });
    })

    ;


}
