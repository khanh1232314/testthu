    package fpoly.edu.poly.luckyshit;

    import android.graphics.BitmapFactory;
    import android.graphics.Color;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    import com.bluehomestudio.luckywheel.LuckyWheel;
    import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
    import com.bluehomestudio.luckywheel.WheelItem;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Random;


    public class MainActivity extends AppCompatActivity {
        private LuckyWheel lw;
        List<WheelItem> wheelItems;
        private int point;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            generateWheelItems();
            lw = findViewById(R.id.lwv);
            lw.addWheelItems(wheelItems);
            lw.setTarget(getRandomIndex());

            Button start = findViewById(R.id.start);
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    lw.rotateWheelTo(getRandomIndex());


                }
            });



        }


        private void generateWheelItems() {
            wheelItems = new ArrayList<WheelItem>();
            wheelItems.add(new WheelItem(Color.parseColor("#B1B2FF"), BitmapFactory.decodeResource(getResources(), R.drawable.ice_cream), ""));

            wheelItems.add(new WheelItem(Color.parseColor("#AAC4FF"), BitmapFactory.decodeResource(getResources(), R.drawable.lemonade), ""));

            wheelItems.add(new WheelItem(Color.parseColor("#D2DAFF"), BitmapFactory.decodeResource(getResources(), R.drawable.orange), ""));

            wheelItems.add(new WheelItem(Color.parseColor("#EEF1FF"), BitmapFactory.decodeResource(getResources(), R.drawable.shop), ""));

            wheelItems.add(new WheelItem(Color.parseColor("#EBC7E8"), BitmapFactory.decodeResource(getResources(), R.drawable.chat), ""));

            wheelItems.add(new WheelItem(Color.parseColor("#BFACE0"), BitmapFactory.decodeResource(getResources(), R.drawable.coupon), ""));

        }

        private int getRandomIndex() {
            int[] ind = new int[]{1, 2, 3, 4, 5, 6};
            int rand = new Random().nextInt(ind.length);
            return ind[rand];

        }
    }
