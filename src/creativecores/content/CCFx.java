package creativecores.content;


import arc.graphics.g2d.Lines;
import creativecores.graphics.CCPal;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;

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
    });

}
