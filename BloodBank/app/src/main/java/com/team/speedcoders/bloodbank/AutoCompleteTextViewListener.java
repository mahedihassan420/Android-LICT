package com.team.speedcoders.bloodbank;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


class AutoCompleteTextViewListener implements AdapterView.OnItemClickListener {
    private AutoCompleteTextView autoCompleteTextView1, autoCompleteTextView2;
    private Context context;

    AutoCompleteTextViewListener(AutoCompleteTextView autoCompleteTextView1, AutoCompleteTextView autoCompleteTextView2, Context context) {
        this.autoCompleteTextView2 = autoCompleteTextView2;
        this.context = context;
        this.autoCompleteTextView1 = autoCompleteTextView1;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (autoCompleteTextView1.getId()) {
            case R.id.division:
            case R.id.inDevision:
                autoCompleteTextView2.setEnabled(true);
                switch (autoCompleteTextView1.getText().toString()) {
                    case "Barisal":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.districts_of_borisal,
                                R.layout.auto_complete_view));
                        break;
                    case "Chittagong":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.districts_of_chittagong,
                                R.layout.auto_complete_view));
                        break;
                    case "Dhaka":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.districts_of_dhaka,
                                R.layout.auto_complete_view));
                        break;
                    case "Khulna":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.districts_of_khulna,
                                R.layout.auto_complete_view));
                        break;
                    case "Mymensingh":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.districts_of_mymensingh,
                                R.layout.auto_complete_view));
                        break;
                    case "Rajshahi":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.districts_of_rajshahi,
                                R.layout.auto_complete_view));
                        break;
                    case "Rangpur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.districts_of_rangpur,
                                R.layout.auto_complete_view));
                        break;
                    case "Sylhet":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.districts_of_sylhet,
                                R.layout.auto_complete_view));
                        break;
                    default:
                        autoCompleteTextView2.setEnabled(false);
                        Toast.makeText(context, "Null values not allowed or spelling mistake", Toast.LENGTH_SHORT).show();
                        break;
                }
                if (autoCompleteTextView2.isEnabled())
                    autoCompleteTextView2.requestFocus();
                break;
            case R.id.destrict:
            case R.id.inDestrict:
                autoCompleteTextView2.setEnabled(true);
                switch (autoCompleteTextView1.getText().toString()) {
                    case "Bogra":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_bogra,
                                R.layout.auto_complete_view));
                        break;
                    case "Joypurhat":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_joypurhat,
                                R.layout.auto_complete_view));
                        break;
                    case "Naogaon":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_naogaon,
                                R.layout.auto_complete_view));
                        break;
                    case "Natore":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_natore,
                                R.layout.auto_complete_view));
                        break;
                    case "Chapainawabganj":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_nawabganj,
                                R.layout.auto_complete_view));
                        break;
                    case "Pabna":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_pabna,
                                R.layout.auto_complete_view));
                        break;
                    case "Rajshahi":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_rajshahi,
                                R.layout.auto_complete_view));
                        break;
                    case "Sirajgonj":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_sirajganj,
                                R.layout.auto_complete_view));
                        break;
                    case "Dinajpur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_dinajpur,
                                R.layout.auto_complete_view));
                        break;
                    case "Gaibandha":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_gaibandha,
                                R.layout.auto_complete_view));
                        break;
                    case "Kurigram":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_kurigram,
                                R.layout.auto_complete_view));
                        break;
                    case "Lalmonirhat":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_lalmonirhat,
                                R.layout.auto_complete_view));
                        break;
                    case "Nilphamari":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_nilphamari,
                                R.layout.auto_complete_view));
                        break;
                    case "Panchagarh":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_panchagarh,
                                R.layout.auto_complete_view));
                        break;
                    case "Rangpur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_rangpur,
                                R.layout.auto_complete_view));
                        break;
                    case "Thakurgaon":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_thakurgaon,
                                R.layout.auto_complete_view));
                        break;
                    case "Netrokona":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_netrokona,
                                R.layout.auto_complete_view));
                        break;
                    case "Sherpur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_sherpur,
                                R.layout.auto_complete_view));
                        break;
                    case "Jamalpur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_jamalpur,
                                R.layout.auto_complete_view));
                        break;
                    case "Mymensingh":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_mymensingh,
                                R.layout.auto_complete_view));
                        break;
                    case "Barguna":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_barguna,
                                R.layout.auto_complete_view));
                        break;
                    case "Barisal":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_barisal,
                                R.layout.auto_complete_view));
                        break;
                    case "Bhola":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_bhola,
                                R.layout.auto_complete_view));
                        break;
                    case "Jhalokati":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_jhalokati,
                                R.layout.auto_complete_view));
                        break;
                    case "Patuakhali":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_patuakhali,
                                R.layout.auto_complete_view));
                        break;
                    case "Pirojpur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_pirojpur,
                                R.layout.auto_complete_view));
                        break;
                    case "Bandarban":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_bandarban,
                                R.layout.auto_complete_view));
                        break;
                    case "Brahmanbaria":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_brahmanbaria,
                                R.layout.auto_complete_view));
                        break;
                    case "Chandpur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_chandpur,
                                R.layout.auto_complete_view));
                        break;
                    case "Comilla":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_comilla,
                                R.layout.auto_complete_view));
                        break;
                    case "Cox's Bazar":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_coxbjr,
                                R.layout.auto_complete_view));
                        break;
                    case "Feni":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_feni,
                                R.layout.auto_complete_view));
                        break;
                    case "Khagrachhari":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_khagrachhari,
                                R.layout.auto_complete_view));
                        break;
                    case "Lakshmipur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_lakshmipur,
                                R.layout.auto_complete_view));
                        break;
                    case "Noakhali":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_noakhali,
                                R.layout.auto_complete_view));
                        break;
                    case "Rangamati":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_rangamati,
                                R.layout.auto_complete_view));
                        break;
                    case "Dhaka":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_dhaka,
                                R.layout.auto_complete_view));
                        break;
                    case "Faridpur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_faridpur,
                                R.layout.auto_complete_view));
                        break;
                    case "Gazipur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_gazipur,
                                R.layout.auto_complete_view));
                        break;
                    case "Gopalganj":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_gopalganj,
                                R.layout.auto_complete_view));
                    case "Sylhet":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_sylhet,
                                R.layout.auto_complete_view));
                        break;
                    case "Sunamganj":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_sunamganj,
                                R.layout.auto_complete_view));
                        break;
                    case "Moulvibazar":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_moulvibazar,
                                R.layout.auto_complete_view));
                        break;
                    case "Habiganj":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_habiganj,
                                R.layout.auto_complete_view));
                        break;
                    case "Satkhira":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_satkhira,
                                R.layout.auto_complete_view));
                        break;
                    case "Narail":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_narail,
                                R.layout.auto_complete_view));
                        break;
                    case "Meherpur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_meherpur,
                                R.layout.auto_complete_view));
                    case "Kishoreganj":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_kishoreganj,
                                R.layout.auto_complete_view));
                        break;
                    case "Madaripur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_madaripur,
                                R.layout.auto_complete_view));
                        break;
                    case "Manikganj":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_manikganj,
                                R.layout.auto_complete_view));
                        break;
                    case "Munshiganj":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_munshiganj,
                                R.layout.auto_complete_view));
                        break;
                    case "Narayanganj":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_narayanganj,
                                R.layout.auto_complete_view));
                        break;
                    case "Narsingdi":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_narsingdi,
                                R.layout.auto_complete_view));
                        break;
                    case "Rajbari":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_rajbari,
                                R.layout.auto_complete_view));
                        break;
                    case "Shariatpur":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_shariatpur,
                                R.layout.auto_complete_view));
                        break;
                    case "Tangail":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_tangail,
                                R.layout.auto_complete_view));
                        break;
                    case "Bagerhat":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_bagerhat,
                                R.layout.auto_complete_view));
                        break;
                    case "Chuadanga":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_chittagong,
                                R.layout.auto_complete_view));
                        break;
                    case "Jessore":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_jessore,
                                R.layout.auto_complete_view));
                        break;
                    case "Jhenaidah":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_jhenaida,
                                R.layout.auto_complete_view));
                        break;
                    case "Khulna":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_khulna,
                                R.layout.auto_complete_view));
                        break;
                    case "Kushtia":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_kushtia,
                                R.layout.auto_complete_view));
                        break;
                    case "Magura":
                        autoCompleteTextView2.setAdapter(ArrayAdapter.createFromResource(context, R.array.upazila_of_magura,
                                R.layout.auto_complete_view));
                        break;
                    default:
                        autoCompleteTextView2.setEnabled(false);
                        Toast.makeText(context, "Null values not allowed or spelling mistake", Toast.LENGTH_SHORT).show();
                        break;
                }
                if (autoCompleteTextView2.isEnabled())
                    autoCompleteTextView2.requestFocus();
                break;
            case R.id.upozila:
            case R.id.inUpazila:
                InputMethodManager inputMethodManager= (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(autoCompleteTextView1.getWindowToken(),0);
                break;
            default:
                Toast.makeText(context, "Null values not allowed or spelling mistake", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
