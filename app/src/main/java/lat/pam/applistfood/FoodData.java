package lat.pam.applistfood;

import android.content.Context;

import java.util.ArrayList;

public class FoodData {
    public static ArrayList<Integer> getGambar() {
        ArrayList<Integer> drawables = new ArrayList<Integer>();
        drawables.add(R.drawable.batagor);
        drawables.add(R.drawable.cireng);
        drawables.add(R.drawable.cappuchino);
        drawables.add(R.drawable.cheesecake);
        drawables.add(R.drawable.donut);
        return drawables;
    }

    public static ArrayList<Food> getData(Context context) {
        ArrayList<Food> list = new ArrayList<Food>();
        list.add(new Food("Batagor", "Batagor merupakan jajanan khas Bandung yang mengadaptasi gaya Tionghoa-Indonesia dan kini sudah dikenal hampir di seluruh wilayah Indonesia.", "7000", context.getDrawable(R.drawable.batagor)));
        list.add(new Food("Cireng", "Cireng adalah jenis makanan ringan yang berasal dari daerah Sunda. Cireng ini dibuat dengan cara menggoreng campuran adonan yang bahan utamanya adalah tepung kanji atau tepung tapioka.", "5000", context.getDrawable(R.drawable.cireng)));
        list.add(new Food("Caphuchino", "Kopi Cappuccino adalah minuman khas Italia yang terdiri dari 1/3 espresso, 1/3 susu steamed, dan 1/3 buih susu.", "10000", context.getDrawable(R.drawable.cappuchino)));
        list.add(new Food("Cheesecake", "Cheesecake adalah kue yang biasanya dimakan sebagai hidangan penutup, dibuat dengan mencampurkan keju yang bertekstur lembut, telur, susu, dan gula.", "20000", context.getDrawable(R.drawable.cheesecake)));
        list.add(new Food("Donut", "Donat adalah suatu bentuk makanan yang digoreng, berdasarkan campuran adonan tepung terigu, telur, metega, dan gula.", "3000", context.getDrawable(R.drawable.donut)));
        return list;
    }
}
