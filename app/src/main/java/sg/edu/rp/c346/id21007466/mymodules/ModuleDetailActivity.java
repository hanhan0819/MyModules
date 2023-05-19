package sg.edu.rp.c346.id21007466.mymodules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class ModuleDetailActivity extends AppCompatActivity {
    TextView textViewModuleCode,textViewModuleName,textViewAcademicYear,textViewSemester,textViewModuleCredit,textViewVenue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_detail);
        textViewModuleCode = findViewById(R.id.textViewModuleCode);
        textViewModuleName = findViewById(R.id.textViewModuleName);
        textViewAcademicYear = findViewById(R.id.textViewAcademicYear);
        textViewSemester = findViewById(R.id.textViewSemester);
        textViewModuleCredit = findViewById(R.id.textViewModuleCredit);
        textViewVenue = findViewById(R.id.textViewVenue);
        Intent intentReceived = getIntent();
        Module module = intentReceived.getParcelableExtra("Module");

        // Set the module information to the corresponding TextViews
        textViewModuleCode.setText("Module Code: " + module.getCode());
        textViewModuleName.setText("Module Name: " + module.getName());
        textViewAcademicYear.setText("Academic Year: " + module.getAcademicYear());
        textViewSemester.setText("Semester: " + module.getSemester());
        textViewModuleCredit.setText("Module Credit: " + module.getCredit());
        textViewVenue.setText("Venue: " + module.getVenue());
    }

    public static class Module implements Parcelable {
        private String code;
        private String name;
        private String academicYear;
        private String semester;
        private int credit;
        private String venue;

        public Module(String code, String name, String academicYear, String semester, int credit, String venue) {
            this.code = code;
            this.name = name;
            this.academicYear = academicYear;
            this.semester = semester;
            this.credit = credit;
            this.venue = venue;
        }

        protected Module(Parcel in) {
            code = in.readString();
            name = in.readString();
            academicYear = in.readString();
            semester = in.readString();
            credit = in.readInt();
            venue = in.readString();
        }

        public static final Creator<Module> CREATOR = new Creator<Module>() {
            @Override
            public Module createFromParcel(Parcel in) {
                return new Module(in);
            }

            @Override
            public Module[] newArray(int size) {
                return new Module[size];
            }
        };

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getAcademicYear() {
            return academicYear;
        }

        public String getSemester() {
            return semester;
        }

        public int getCredit() {
            return credit;
        }

        public String getVenue() {
            return venue;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(code);
            dest.writeString(name);
            dest.writeString(academicYear);
            dest.writeString(semester);
            dest.writeInt(credit);
            dest.writeString(venue);
        }
    }
}