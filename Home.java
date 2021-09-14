package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Home extends AppCompatActivity {

    //Diseases Arraylist that contain all diseases index , treatments , and symptoms
    ArrayList<Disease> diseases;

    //**********************************Represent Symptoms levels*********************************//

    int Low = -1;
    int Normal = 0;
    int High = 1;

    //**********************************Variables Section*****************************************//
    String _Name;

    String _ID;
    double _ID_ = 0;

    String _Age;
    double _Age_;

    String _WBC;
    double _WBC_;

    String _Neut;
    double _Neut_;

    String _Lymph;
    double _Lymph_;

    String _RBC;
    double _RBC_;

    String _HCT;
    double _HCT_;

    String _Urea;
    double _Urea_;

    String _Hb;
    double _Hb_;

    String _Cr;
    double _Cr_;

    String _Iron;
    double _Iron_;

    String _HDL;
    double _HDL_;

    String _AO;
    double _AO_;

    //***********************Radio Buttons variables************************************************
    boolean Gender; // True = Man , False = Female
    boolean Smoking;//True = Smoking , False = no smoking
    boolean isWhite;//True = white person , False = black Person
    boolean isEastern;//True = Eastern person , False = Non Eastern Person
    boolean isPregnant;//True = women is pregnant , False = women isn't pregnant

    RadioButton male, female, smoking, noSmoking, white, black, eastern, nonEastern, pregnant, nonPregnant;
    RadioGroup GenderGroup, SmokingGroup, ColorGroup, Eastern, PregnantGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //***********************Initializing Diseases**********************************************
        diseases = new ArrayList<>();
        diseases.add(new Disease(0, "אנמיה.", "שני כדורי 10 מג של B12 ביום למשך חודש.", "תסמינים: המוגלובין נמוך,תאי כדורי דם לבנים נמוכים ונפח כדורי דם אדומות נמוך."));
        diseases.add(new Disease(1, "דיאטה.", "לתאם פגישה עם תזונאי.", "תסמינים: רמת שתן בדם נמוכה או גבוהה."));
        diseases.add(new Disease(2, "דימום.", "להתפנות בדחיפות לבית החולים.", "תסמינים: רמת כדורי דם אדומות נמוכה,נפח כדורי דם אדומות נמוך."));
        diseases.add(new Disease(3, "היפרליפידמיה - שומנים בדם.", "לתאם פגישה עם תזונאי, כדור 5 מג של סימוביל ביום למשך שבוע.", "תסמינים: רמת HDL (כולסטרול ׳טוב׳) נמוכה."));
        diseases.add(new Disease(4, "הפרעה ביצירת הדם.", "כדור 10 מג של B12 ביום למשך חודש + כדור 5 מג של חומצה פולית ביום למשך חודש.", "תסמינים: כמות נמוכה של כדורי דם לבנים האחראים בעיקר על חיסול חיידקים,כמות נמוכה של תאי הדם הלבנים האחראים על הריגת נגיפים או חייקים הנמצאים בגוף וגם נובע מכמות גבוהה של כדוריות דם אדומות."));
        diseases.add(new Disease(5, "הפרעה המטולוגית.", "זריקה של הורמון לעידוד ייצור תאי הדם האדומים.", "תסמינים: נובע בעיקר מרמת המוגלובין נמוכה."));
        diseases.add(new Disease(6, "הרעלת ברזל.", "להתפנות לבית החולים.", "תסמינים: רמת ברזל בדם גבוהה."));
        diseases.add(new Disease(7, "התייבשות.", "מנוחה מוחלטת בשכיבה, החזרת נוזלים בשתייה.", "תסמינים: נובע בעיקר כאשר רמת השתנן בדם אינה תקינה."));
        diseases.add(new Disease(8, "זיהום.", "אנטיביוטיקה ייעודית.", "תסמינים: נובע כאשר כמות כדורויות הדם הלבנות גבוהה,בעקבות כמות גבוהה/נמוכה של תאי דם לבנים האחראים בעיקר על חיסול חיידקים וגם כמות גבוהה של תאי דם לבנים האחראים על הריגת נגיפים וחיידקים."));
        diseases.add(new Disease(9, "חוסר בוויטמינים.", "הפנייה לבדיקת דם לזיהוי הוויטמינים החסרים.", "תסמינים: רמת נמוכה של פוספטזה אלקלית."));
        diseases.add(new Disease(10, "מחלה ויראלית.", "לנוח בבית.", "תסמינים: רמה נמוכה של כדוריות דם לבנות."));
        diseases.add(new Disease(11, "מחלות בדרכי המרה.", "הפנייה לטיפול כירורגי.", "תסמינים: נובע בעיקר מרמה גבוהה של פוספטזה אלקלית."));
        diseases.add(new Disease(12, "מחלות לב.", "לתאם פגישה עם תזונאי.", "תסמינים: נובע בעיקר מרמה נמוכה של HDL הקרוי גם ׳הכולסטרול הטוב׳."));
        diseases.add(new Disease(13, "מחלת דם.", "שילוב של ציקלופוספאמיד וקורטיקוסרואידים.", "תסמינים: נובע בעיקר מרמה נמוכה של כדוריות דם לבנות."));
        diseases.add(new Disease(14, "מחלת כבד.", "הפנייה לאבחנה ספציפית לצורך קביעת טיפול.", "תסמינים: נובע בעיקר מרמה גבוהה של פוספטזה אלקלית וגם רמת השתנן בדם נמוכה."));
        diseases.add(new Disease(15, "מחלת כליה.", "איזון את רמות הסוכר בדם.", "תסמינים: נובע בעקבות רמה גבוהה של השתנן בדם וגם מרמה גבוהה של קריטאינין."));
        diseases.add(new Disease(16, "מחסור בברזל.", "שני כדורי 10 מג של B12 ביום למשך חודש.", "תסמינים: נובע מרמה נמוכה של ברזל וגם רמת המוגלובין נמוכה."));
        diseases.add(new Disease(17, "מחלות שריר.", "שני כדורי 5 מג של כורכום c3 של אלטמן ביום למשך חודש.", "תסמינים: נובע מרמת קריטאינין גבוהה."));
        diseases.add(new Disease(18, "מעשנים.", "להפסיק לעשן.", "תסמינים: רמה גבוהה של נפח כדורויות דם אדומות בתוך כלל נוזל הדם וגם כמות גבוהה של כדורויות דם אדומות."));
        diseases.add(new Disease(19, "מחלת ריאות.", "להפסיק לעשן / הפנייה לצילום רנטגן של הריאות.", "תסמינים: רמה גבוהה של כדורויות דם אדומות וגם מדובר באדם אשר מעשן."));
        diseases.add(new Disease(20, "פעילות יתר של בלוטת התריס.", ".Propylthiouracil להקטנת פעילות בלוטת התריס", "תסמינים: רמה גבוהה של פוספטזה אלקלית."));
        diseases.add(new Disease(21, "סוכרת מבוגרים.", "התאמת אינסולין למטופל.", "תסמינים: רמה נמוכה של HDL הקרוי גם ׳הכולסטרול הטוב׳."));
        diseases.add(new Disease(22, "סרטן.", "אנטרקטיניב - Entrectinib.", "תסמינים: רמה לא תקינה של כדוריות דם לבנות,רמה נמוכה של כמות תאי הדם הלבנים האחראים בעיקר על חיסול חיידקים  וגם רמה גבוהה של תאי דם לבנים האחראים על הריגת נגיפים."));
        diseases.add(new Disease(23, "צריכה מוגברת של בשר.", "לתאם פגישה עם תזונאי.", "תסמינים: נובע מרמת קריטאינין גבוהה."));
        diseases.add(new Disease(24, "שימוש בתרופות שונות.", "הפנייה לרופא המשפחה לצורך בדיקת התאמה בין התרופות.", "תסמינים: כמות גבוהה של פוספטזה אלקלית."));
        diseases.add(new Disease(25, "תת תזונה.", "לתאם פגישה עם תזונאי.", "תסמינים:נובע מרמת שתנן בדם נמוכה,כמות נמוכה של ברזל בדם וגם רמת ברזל נמוכה."));

        //inorder to actually render home view page.
        setContentView(R.layout.activity_home);

        //***********************Radio Buttons matching*********************************************
        male = findViewById(R.id.Gender_male);
        female = findViewById(R.id.Gender_female);
        GenderGroup = findViewById(R.id.radioGroup1);

        smoking = findViewById(R.id.Smoking);
        noSmoking = findViewById(R.id.NonSmoking);
        SmokingGroup = findViewById(R.id.radioGroup2);

        white = findViewById(R.id.wSkin);
        black = findViewById(R.id.bSkin);
        ColorGroup = findViewById(R.id.radioGroup3);

        eastern = findViewById(R.id.Eastern);
        nonEastern = findViewById(R.id.NonEastern);
        Eastern = findViewById(R.id.radioGroup4);

        pregnant = findViewById(R.id.Pregnant);
        nonPregnant = findViewById(R.id.UnPregnant);
        PregnantGroup = findViewById(R.id.radioGroup5);

        //***********************Radio Buttons Listener*********************************************
        GenderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.Gender_male:
                        Gender = true;
                        break;

                    case R.id.Gender_female:
                        Gender = false;
                        break;
                }
            }
        });

        SmokingGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Smoking:
                        Smoking = true;
                        break;
                    case R.id.NonSmoking:
                        Smoking = false;
                        break;
                }
            }
        });

        ColorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.wSkin:
                        isWhite = true;
                        break;

                    case R.id.bSkin:
                        isWhite = false;
                        break;
                }
            }
        });

        Eastern.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Eastern:
                        isEastern = true;
                        break;

                    case R.id.NonEastern:
                        isEastern = false;
                        break;
                }
            }
        });

        PregnantGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Pregnant:
                        isPregnant = true;
                        break;

                    case R.id.UnPregnant:
                        isPregnant = false;
                        break;
                }
            }
        });

        /***********************End of "onCreate" function*****************************************/
    }

    public void MakeDiagnostic(View view) throws IOException {

        TextView title = (TextView) findViewById(R.id.textView18);
        EditText Name = findViewById(R.id.PatientName);
        EditText ID = findViewById(R.id.PatientID);
        EditText Age = findViewById(R.id.editTextTextPersonName0);
        EditText WBC = findViewById(R.id.editTextTextPersonName1);
        EditText Neut = findViewById(R.id.editTextTextPersonName2);
        EditText Lymph = findViewById(R.id.editTextTextPersonName3);
        EditText RBC = findViewById(R.id.editTextTextPersonName4);
        EditText HCT = findViewById(R.id.editTextTextPersonName5);
        EditText Urea = findViewById(R.id.editTextTextPersonName6);
        EditText Hb = findViewById(R.id.editTextTextPersonName7);
        EditText Cr = findViewById(R.id.editTextTextPersonName8);
        EditText Iron = findViewById(R.id.editTextTextPersonName9);
        EditText HDL = findViewById(R.id.editTextTextPersonName10);
        EditText AO = findViewById(R.id.editTextTextPersonName11);


        //**********************************Variables Section*************************************//
        _Name = Name.getText().toString();
        if (_Name.matches("")) {
            Toast.makeText(this, "You did not enter Name", Toast.LENGTH_SHORT).show();
            return;
        }


        _ID = ID.getText().toString();
        if (_ID.matches("")) {
            Toast.makeText(this, "You did not enter an ID", Toast.LENGTH_SHORT).show();
            return;
        }
        _ID_ = Double.parseDouble(_ID);

        _Age = Age.getText().toString();
        if (_Age.matches("")) {
            Toast.makeText(this, "You did not enter an Age", Toast.LENGTH_SHORT).show();
            return;
        }
        _Age_ = Double.parseDouble(_Age);

        //**************Checking validation for radio buttons*************************************//
        //Gender radio buttons Checking
        if (GenderGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Gender section is unchecked!", Toast.LENGTH_SHORT).show();
            return;
        }

        //Pregnant radio buttons Checking
        if (PregnantGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Pregnancy section is unchecked!", Toast.LENGTH_SHORT).show();
            return;
        }

        //Smoking radio buttons Checking
        if (SmokingGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Smoking section is unchecked!", Toast.LENGTH_SHORT).show();
            return;
        }

        //Skin Color radio buttons Checking
        if (ColorGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Skin Color section is unchecked!", Toast.LENGTH_SHORT).show();
            return;
        }

        //Eastern radio buttons Checking
        if (Eastern.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Eastern section is unchecked!\"", Toast.LENGTH_SHORT).show();
            return;
        }
        //checking whether patient is male & in pregnant
        if (isPregnant && Gender) {
            Toast.makeText(this, "Patient could not be man and in Pregnant", Toast.LENGTH_SHORT).show();
            return;
        }
        //**********************************Continuing Variables Section***************************//
        //White Blood Cells
        _WBC = WBC.getText().toString();
        if (_WBC.matches("")) {
            Toast.makeText(this, "You did not enter an White Blood Cells", Toast.LENGTH_SHORT).show();
            return;
        }
        _WBC_ = Double.parseDouble(_WBC);

        //Neutrophil
        _Neut = Neut.getText().toString();
        if (_Neut.matches("")) {
            Toast.makeText(this, "You did not enter Neutrophil", Toast.LENGTH_SHORT).show();
            return;
        }
        _Neut_ = Double.parseDouble(_Neut);

        //Lymphocytes
        _Lymph = Lymph.getText().toString();
        if (_Lymph.matches("")) {
            Toast.makeText(this, "You did not enter Lymphocytes", Toast.LENGTH_SHORT).show();
            return;
        }
        _Lymph_ = Double.parseDouble(_Lymph);

        //Red Blood Cells
        _RBC = RBC.getText().toString();
        if (_RBC.matches("")) {
            Toast.makeText(this, "You did not enter Red Blood Cells", Toast.LENGTH_SHORT).show();
            return;
        }
        _RBC_ = Double.parseDouble(_RBC);

        //HCT
        _HCT = HCT.getText().toString();
        if (_HCT.matches("")) {
            Toast.makeText(this, "You did not enter an HCT", Toast.LENGTH_SHORT).show();
            return;
        }
        _HCT_ = Double.parseDouble(_HCT);

        //Urea
        _Urea = Urea.getText().toString();
        if (_Urea.matches("")) {
            Toast.makeText(this, "You did not enter an Urea", Toast.LENGTH_SHORT).show();
            return;
        }
        _Urea_ = Double.parseDouble(_Urea);

        //Hemoglobin
        String _Hb = Hb.getText().toString();
        if (_Hb.matches("")) {
            Toast.makeText(this, "You did not enter an Hemoglobin", Toast.LENGTH_SHORT).show();
            return;
        }
        _Hb_ = Double.parseDouble(_Hb);

        //Creatinine
        _Cr = Cr.getText().toString();
        if (_Cr.matches("")) {
            Toast.makeText(this, "You did not enter Creatinine", Toast.LENGTH_SHORT).show();
            return;
        }
        _Cr_ = Double.parseDouble(_Cr);

        //Iron
        String _Iron = Iron.getText().toString();
        if (_Iron.matches("")) {
            Toast.makeText(this, "You did not enter an Iron", Toast.LENGTH_SHORT).show();
            return;
        }
        _Iron_ = Double.parseDouble(_Iron);

        //High Density Lipoprotein
        String _HDL = HDL.getText().toString();
        if (_HDL.matches("")) {
            Toast.makeText(this, "You did not enter an High Density Lipoprotein", Toast.LENGTH_SHORT).show();
            return;
        }
        _HDL_ = Double.parseDouble(_HDL);

        //Alkaline Phosphatase
        String _AO = AO.getText().toString();
        if (_AO.matches("")) {
            Toast.makeText(this, "You did not enter an Alkaline Phosphatase", Toast.LENGTH_SHORT).show();
            return;
        }
        _AO_ = Double.parseDouble(_AO);

        //**********************************Checking Section**************************************//
        //בדיקת אנמיה
        if (checkAnemia()) {
            diseases.get(0).setStatus(true);
        }
        //בדיקת דיאטה
        if (checkDiet()) {
            diseases.get(1).setStatus(true);
        }

        //בדיקת דימום
        if (checkBleeding()) {
            diseases.get(2).setStatus(true);
        }

        //בדיקת שומנים בדם
        if (checkBloodFats()) {
            diseases.get(3).setStatus(true);
        }

        //בדיקת הפרעה ביצירת הדם חשוב חשוב חשוב!!!!
        if (checkBloodDisorder()) {
            diseases.get(4).setStatus(true);
        }

        //בדיקה הפערה מטולוגוית
        if (checkMethodologicalDisorder()) {
            diseases.get(5).setStatus(true);
        }

        //בדיקת הרעלת ברזל
        if (checkIronPoisoning()) {
            diseases.get(6).setStatus(true);
        }

        //בדיקת התייבשות
        if (checkDehydration()) {
            diseases.get(7).setStatus(true);
        }

        //בדיקת זיהום
        if (checkInfection()) {
            diseases.get(8).setStatus(true);
        }

        //בדיקת חוסר וויטמנים
        if (checkLackVitamins()) {
            diseases.get(9).setStatus(true);
        }

        //בדיקת מחלה ויראלית
        if (checkViralDisease()) {
            diseases.get(10).setStatus(true);
        }

        //בדיקת מחלות בדרכי המרה
        if (checkBiliaryTract()) {
            diseases.get(11).setStatus(true);
        }

        //בדיקת מחלות לב
        if (checkHeartDiseases()) {
            diseases.get(12).setStatus(true);
        }

        //בדיקת מחלות דם
        if (checkBloodDiseases()) {
            diseases.get(13).setStatus(true);
        }

        // בדיקת מחלות כבד
        if (checkLiverDiseases()) {
            diseases.get(14).setStatus(true);
        }

        // בדיקת מחלות כליה
        if (checkKidneyDiseases()) {
            diseases.get(15).setStatus(true);
        }

        //בדיקת מחסור ברזל
        if (checkIronLack()) {
            diseases.get(16).setStatus(true);
        }

        //בדיקת מחלות שריר
        if (checkMuscleDiseases()) {
            diseases.get(17).setStatus(true);
        }

        // בדיקת האם אדם סובל מעישון(?)
        if (checkSmooking()) {
            diseases.get(18).setStatus(true);
        }

        //בדיקת מחלות ריאות חשוב חשוב חשוב!!!
        if (checkLungDiseases()) {
            diseases.get(19).setStatus(true);
        }

        //בדיקת פעילות יתר של בלוטת התריס
        if (checkThyroidGland()) {
            diseases.get(20).setStatus(true);
        }

        //בדיקת סוכרת למבוגרים
        if (checkDiabetesAdults()) {
            diseases.get(21).setStatus(true);
        }

        //בדיקת סרטן
        if (checkCancer()) {
            diseases.get(22).setStatus(true);
        }

        //צריכה מוגברת של בשר
        if (checkConsumptionMeat()) {
            diseases.get(23).setStatus(true);
        }

        //בדיקת שימוש בתרופות שונות
        if (checkDifferentDrugs()) {
            diseases.get(24).setStatus(true);
        }

        //בדיקת תת תזונה
        if (checkMalnutrition()) {
            diseases.get(25).setStatus(true);
        }

        //*****************************Result Section*********************************************//
        Toast.makeText(Home.this, "Patient records has been saved!", Toast.LENGTH_LONG).show();
        //print_s represent patient information.
        StringBuilder print_s = new StringBuilder();
        int diseaseCounter = 0;
        print_s.append("שם החולה: ").append(_Name).append("\n").append("ת.ז: ").append(_ID).append("\n").append("גיל: ").append(_Age).append("\n\n");
        print_s.append("אבחנה וטיפול: ").append("\n\n");
        for (int i = 0; i < diseases.size(); i++) {
            if (diseases.get(i).status) {
                diseaseCounter++;
                print_s.append("שם המחלה: ").append(diseases.get(i).name).append("\n").append(diseases.get(i).symptoms).append("\n").append("דרכי טיפול: ").append(diseases.get(i).cure).append("\n\n");
            }
        }
        print_s.append("                 ------------------------------------------------------------------->\n");
        AlertDialog.Builder build = new AlertDialog.Builder(Home.this);
        build.setCancelable(true);
        if (diseaseCounter == 0) {
            build.setTitle("הידד אתה בריא!");
        } else {
            build.setTitle("תוצאות:                          ");
            build.setMessage(print_s.toString());
        }
        build.show();

        //bypass array if user wants to enter different values again
        for (int i = 0; i < diseases.size(); i++) {
            diseases.get(i).setStatus(false);
        }

//        //***********************************Export Section***************************************//
        String txtName = _Name + "," + _ID + ".txt";
        File externalStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(externalStorageDir, txtName);
        if (myFile.exists()) {
            try {
                FileOutputStream fOut = new FileOutputStream(myFile, true);
                OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                myOutWriter.append(print_s.toString());
                myOutWriter.close();
                fOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(directory, txtName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append(print_s.toString());
            fileWriter.flush();
            fileWriter.close();
        }
        Toast.makeText(Home.this, "File Exported Successfully", Toast.LENGTH_SHORT).show();
        /***********************************End of MakeDiagnostic function************************/

    }

    //***********************************Checking Parameters for patient***************************//
    int checkWBC(double _WBC_, double _Age_) {
        //AGE >= 18
        if (_Age_ >= 18 && (_WBC_ < 4500 || _WBC_ > 11000)) {
            if (_WBC_ < 4500) {
                return Low;
            }

            if (_WBC_ > 11000) {
                return High;
            }
        }

        //AGE is 4 - 17
        if (_Age_ >= 4 && _Age_ <= 17 && (_WBC_ < 5500 || _WBC_ > 15500)) {
            if (_WBC_ < 5500) {
                return Low;
            }

            if (_WBC_ > 15500) {
                return High;
            }
        }

        //AGE 0 - 3
        if (_Age_ >= 0 && _Age_ <= 3 && (_WBC_ < 6000 || _WBC_ > 17500)) {
            if (_WBC_ < 6000) {
                return Low;
            }

            if (_WBC_ > 17500) {
                return High;
            }
        }
        return Normal;
    }

    int checkNeutrophil(double _Neut_, double _WBC_) {
        if (_Neut_ / _WBC_ > 0.54 || _Neut_ / _WBC_ < 0.28) {
            if (_Neut_ / _WBC_ > 0.54) {
                return High;
            }
            if (_Neut_ / _WBC_ < 0.28) {
                return Low;
            }
        }
        return Normal;
    }

    int checkLymphocytes(double _Lymph_, double _WBC_) {
        if (_Lymph_ / _WBC_ > 0.52 || _Lymph_ / _WBC_ < 0.36) {
            if (_Lymph_ / _WBC_ > 0.52) {
                return High;
            }

            if (_Lymph_ / _WBC_ < 0.36) {
                return Low;
            }
        }
        return Normal;
    }

    int checkRBC(double _RBC_) {
        if (_RBC_ < 4.5 || _RBC_ > 6) {
            if (_RBC_ < 4.5) {
                return Low;
            }
            if (_RBC_ > 6) {
                return High;
            }
        }
        return Normal;
    }

    int checkHCT(boolean Gender, double _HCT_, double _WBC_, double _RBC_) {
        //Male
        if (Gender) {
            if (_HCT_ / (_WBC_ + _RBC_) > 0.54) {
                return High;
            }
            if (_HCT_ / (_WBC_ + _RBC_) < 0.37) {
                return Low;
            }
        }
        //Female
        else {
            if (_HCT_ / (_WBC_ + _RBC_) > 0.47) {
                return High;
            }
            if (_HCT_ / (_WBC_ + _RBC_) < 0.33) {
                return Low;
            }
        }
        return Normal;
    }

    int checkUrea(double _Urea_, boolean isEastern) {
        //for NonEastern
        if (_Urea_ > 43 && !isEastern) {
            return High;
        } else if (_Urea_ < 17 && !isEastern) {
            return Low;
        }
        //Eastern
        if (_Urea_ > 47.3 && isEastern) {
            return High;
        } else if (_Urea_ < 18.7 && isEastern) {
            return Low;
        }
        return Normal;
    }

    //IMPORTANT!!!
    /*Method will return Low or Normal .. High is undefined*/
    int checkHemoglobin(double _Age_, double _Hb_) {
        //(Hb)  - male & female
        if (_Age_ > 17 && _Hb_ < 12) {
            return Low;
        }
        //(hb) - kids
        if (_Age_ <= 17 && _Hb_ < 11.5) {
            return Low;
        }
        return Normal;
    }

    int checkCreatinine(double _Age_, double _Cr_) {
        //babies
        if (_Age_ >= 0 && _Age_ <= 2) {
            if (_Cr_ > 0.5) {
                return High;
            }
            if (_Cr_ < 0.2) {
                return Low;
            }
            //kids
        } else if (_Age_ >= 3 && _Age_ <= 17) {
            if (_Cr_ > 1) {
                return High;
            }
            if (_Cr_ < 0.5) {
                return Low;
            }
            //adults
        } else if (_Age_ >= 18 && _Age_ <= 59) {
            if (_Cr_ > 1) {
                return High;
            }
            if (_Cr_ < 0.6) {
                return Low;
            }
            //seniors (age 60+)
        } else {
            if (_Cr_ > 1.2) {
                return High;
            }
            if (_Cr_ < 0.6) {
                return Low;
            }
        }
        return Normal;
    }

    int checkIron(boolean Gender, double _Iron_) {
        // Iron - male
        if (Gender) {
            if (_Iron_ < 60) {
                return Low;
            }
            if (_Iron_ > 160) {
                return High;
            }
        }

        // IRON - female
        else {
            if (_Iron_ < 48 && !isPregnant) {
                return Low;
            }
            if (_Iron_ < 48 && isPregnant) {
                return Normal;
            }
            if (_Iron_ > 128) {
                return High;
            }
        }
        return Normal;
    }

    //IMPORTANT!!!
    /*Method will return Low or Normal .. High is undefined*/
    int checkHDL(boolean Gender, boolean isWhite, double _HDL_) {
        // HDL - male white
        if (Gender && isWhite) {
            if (_HDL_ < 29) {
                return Low;
            }
        }

        // HDL - female white
        if (!Gender && isWhite) {
            if (_HDL_ < 34) {
                return Low;
            }
        }

        // HDL - male black
        if (Gender && !isWhite) {
            if (_HDL_ < 34.8) {
                return Low;
            }
        }

        // HDL - female black
        if (!Gender && !isWhite) {
            if (_HDL_ < 40.8) {
                return Low;
            }
        }
        return Normal;
    }

    int checkAlkalinePhosphatase(boolean isEastern, double _AO_) {
        //Eastern
        if (isEastern) {
            if (_AO_ > 120) {
                return High;
            }
            if (_AO_ < 60) {
                return Low;
            }
            //Non Eastern
        } else {
            if (_AO_ > 90) {
                return High;
            }
            if (_AO_ < 30) {
                return Low;
            }
        }
        return Normal;
    }

    //***********************************Checking Diseases functions******************************//
    //בדיקת אנמיה
    boolean checkAnemia() {
        if (checkRBC(_RBC_) == Low && checkHCT(Gender, _HCT_, _WBC_, _RBC_) == Low && checkHemoglobin(_Age_, _Hb_) == Low) {
            return true;
        }
        return false;
    }

    //בדיקת דיאטה
    boolean checkDiet() {
        if (checkUrea(_Urea_, isEastern) != Normal && !checkKidneyDiseases() && !checkMalnutrition() && !checkLiverDiseases()) {
            return true;
        }
        return false;
    }

    //בדיקת דימום
    //maybe add more later...
    boolean checkBleeding() {
        if (checkRBC(_RBC_) == Low && checkHCT(Gender, _HCT_, _WBC_, _RBC_) == Low) {
            return true;
        }
        return false;
    }

    // בדיקת שומנים בדם
    boolean checkBloodFats() {
        if (checkHDL(Gender, isWhite, _HDL_) == Low)
            return true;
        return false;
    }

    //בדיקת הפרעה ביצירת הדם חשוב חשוב חשוב!!!!
    boolean checkBloodDisorder() {
        if (checkLymphocytes(_Lymph_, _WBC_) == High && checkNeutrophil(_Neut_, _WBC_) == Low && checkRBC(_RBC_) == High) {
            return true;
        }
        return false;
    }

    //בדיקה הפערה מטולוגוית
    boolean checkMethodologicalDisorder() {
        if (checkHemoglobin(_Age_, _Hb_) == Low && !checkAnemia() && !checkBleeding()) {
            return true;
        }
        return false;
    }

    //בדיקת הרעלת ברזל
    boolean checkIronPoisoning() {
        if (checkIron(Gender, _Iron_) == High) {
            return true;
        }
        return false;
    }

    //בדיקת התייבשות
    boolean checkDehydration() {
        if (checkUrea(_Urea_, isEastern) != Normal && !checkDiet()) {
            return true;
        }
        return false;
    }

    //בדיקת זיהום
    boolean checkInfection() {
        if (checkWBC(_WBC_, _Age_) == High && checkLymphocytes(_Lymph_, _WBC_) == High && checkNeutrophil(_Neut_, _WBC_) != Normal) {
            return true;
        }
        return false;
    }

    //בדיקת חוסר וויטמנים
    boolean checkLackVitamins() {
        if (checkAlkalinePhosphatase(isEastern, _AO_) == Low && !checkMalnutrition()) {
            return true;
        }
        return false;
    }

    //בדיקת מחלה ויראלית
    boolean checkViralDisease() {
        if (checkWBC(_WBC_, _Age_) == Low && !checkCancer()) {
            return true;
        }
        return false;
    }

    //בדיקת מחלות בדרכי המרה
    boolean checkBiliaryTract() {
        if (checkAlkalinePhosphatase(isEastern, _AO_) == High && !isPregnant && !checkLiverDiseases()) {
            return true;
        }
        return false;
    }

    //בדיקת מחלות לב
    boolean checkHeartDiseases() {
        if (checkHDL(Gender, isWhite, _HDL_) == Low) {
            return true;
        }
        return false;
    }

    //בדיקת מחלות דם
    boolean checkBloodDiseases() {
        if (checkWBC(_WBC_, _Age_) == Low && !checkInfection() && !checkCancer()) {
            return true;
        }
        return false;
    }

    // בדיקת מחלות כבד
    boolean checkLiverDiseases() {
        if (checkAlkalinePhosphatase(isEastern, _AO_) == High && checkUrea(_Urea_, isEastern) == Low && !isPregnant) {
            return true;
        }
        return false;
    }

    // בדיקת מחלות כליה
    boolean checkKidneyDiseases() {
        if (checkUrea(_Urea_, isEastern) == High && checkCreatinine(_Age_, _Cr_) == High) {
            return true;
        }
        return false;
    }

    //בדיקת מחסור ברזל
    boolean checkIronLack() {
        if (checkIron(Gender, _Iron_) == Low && checkHemoglobin(_Age_, _Hb_) == Low) {
            return true;
        }
        return false;
    }

    //בדיקת מחלות שריר
    boolean checkMuscleDiseases() {
        if (!checkKidneyDiseases() && checkCreatinine(_Age_, _Cr_) == High) {
            return true;
        }
        return false;
    }

    // בדיקת האם אדם סובל מעישון
    boolean checkSmooking() {
        if (checkRBC(_RBC_) == High && checkHCT(Gender, _HCT_, _WBC_, _RBC_) == High) {
            return true;
        }
        return false;
    }

    //בדיקת מחלות ריאות
    boolean checkLungDiseases() {
        if (checkRBC(_RBC_) == High && !checkSmooking() && !checkBloodDisorder()) {
            return true;
        }
        return false;
    }

    //בדיקת פעילות יתר של בלוטת התריס
    boolean checkThyroidGland() {
        if (checkAlkalinePhosphatase(isEastern, _AO_) == High && !isPregnant && !checkBiliaryTract()) {
            return true;
        }
        return false;
    }

    //בדיקת סוכרת למבוגרים
    boolean checkDiabetesAdults() {
        if (checkAlkalinePhosphatase(isEastern, _AO_) == Low) {
            return true;
        }
        return false;
    }

    //בדיקת סרטן
    boolean checkCancer() {
        //סרטן לימפופמה
        if (checkWBC(_WBC_, _Age_) != Normal && checkNeutrophil(_Neut_, _WBC_) == Low && checkLymphocytes(_Lymph_, _WBC_) == High) {
            return true;
        }
        return false;
    }

    //צריכה מוגברת של בשר
    boolean checkConsumptionMeat() {
        if (checkCreatinine(_Age_, _Cr_) == High && !checkMuscleDiseases()) {
            return true;
        }
        return false;
    }

    //בדיקת שימוש בתרופות שונות
    boolean checkDifferentDrugs() {
        if (checkAlkalinePhosphatase(isEastern, _AO_) == High && !checkThyroidGland()) {
            return true;
        }
        return false;
    }

    //בדיקת תת תזונה
    boolean checkMalnutrition() {
        if (checkUrea(_Urea_, isEastern) == Low && checkCreatinine(_Age_, _Cr_) == Low && checkIron(Gender, _Iron_) == Low) {
            return true;
        }
        return false;
    }
}

