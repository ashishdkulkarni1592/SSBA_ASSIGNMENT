package com.ssba.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.ChipGroup;
import com.ssba.R;
import com.ssba.adapter.WorkExperienceAdapter;
import com.ssba.api.ApiImpl;
import com.ssba.callback.ApiCallback;
import com.ssba.databinding.ActivityCvBinding;
import com.ssba.model.MResume;
import com.ssba.model.WorkExperiance;
import com.ssba.utils.ApiError;
import com.ssba.utils.Connectivity;
import com.ssba.utils.ProgressDialogUtils;

import java.util.ArrayList;
import java.util.List;

public class MyCVActivity extends AppCompatActivity
{

    ApiImpl api;
    WorkExperienceAdapter workExperienceAdapter;
    RecyclerView rvWorkExp;
    List<WorkExperiance> workExperianceList=new ArrayList<>();
    ActivityCvBinding binding;
    ProgressDialogUtils progressDialogUtils;
    ChipGroup chipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_cv);
        rvWorkExp=binding.rvWorkExp;
        chipGroup=binding.chipGroup;
        api=ApiImpl.getInstance(MyCVActivity.this);
        progressDialogUtils = new ProgressDialogUtils(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MyCVActivity.this);
        rvWorkExp.setLayoutManager(mLayoutManager);
        rvWorkExp.addItemDecoration(new DividerItemDecoration(rvWorkExp.getContext(), DividerItemDecoration.VERTICAL));
        rvWorkExp.setItemAnimator(new DefaultItemAnimator());
        rvWorkExp.setHasFixedSize(true);

        progressDialogUtils.setMessage("Getting Data");
        progressDialogUtils.show();

        if(Connectivity.isConnected(MyCVActivity.this))
        {
            api.getResumeData(new ApiCallback<MResume>() {
                @Override
                public void onSuccess(MResume mResume)
                {
                    try
                    {
                        progressDialogUtils.dismiss();
                        workExperianceList=mResume.getData().getWorkExperiance();
                        setTextForHtml(binding.tvPersonName,mResume.getName());
                        setTextForHtml(binding.tvexperienceSummery,mResume.getData().getExperianceSummery().getSkillsSummery()+"<br>"+mResume.getData().getExperianceSummery().getOverallSummery());

                        setTextForHtml(binding.tvDOB,mResume.getData().getPersonalDetails().getDateOfBirth());
                        setTextForHtml(binding.tvMaritialStatus,mResume.getData().getPersonalDetails().getMaritialStatus());
                        setTextForHtml(binding.tvLanguage,mResume.getData().getPersonalDetails().getLanguageKnown());
                        setTextForHtml(binding.tvReferences,mResume.getData().getPersonalDetails().getReferences());

                        setTextForHtml(binding.tvMobile,mResume.getPhone());
                        setTextForHtml(binding.tvEmail,mResume.getEmail());

                        setTextForHtml(binding.tvDomain,mResume.getData().getTechnicalSummery().getDomain());
                        setTextForHtml(binding.tvProgrammingLanguages,mResume.getData().getTechnicalSummery().getProgrammingLanguages());
                        setTextForHtml(binding.tvOs,mResume.getData().getTechnicalSummery().getOperatingSystem());
                        setTextForHtml(binding.toolsPackages,"<b>Tools / DB / Packages / Framework / ERP Components</b><br>"+mResume.getData().getTechnicalSummery().getTools().getPrimary()+"<br>"+mResume.getData().getTechnicalSummery().getTools().getBeginner());

                        setTextForHtml(binding.tvPrimary,mResume.getData().getTechnicalSummery().getProfessionalTrainigs().getPrimaryTraining());
                        setTextForHtml(binding.tvSecondary,mResume.getData().getTechnicalSummery().getProfessionalTrainigs().getSecondaryTraining());

                        setTextForHtml(binding.tveducation,mResume.getData().getEducationalSummery().getPostGraduation()+"<br>"+mResume.getData().getEducationalSummery().getBachelorEducation()+"<br>"+mResume.getData().getEducationalSummery().getOther());

                        workExperienceAdapter=new WorkExperienceAdapter(MyCVActivity.this,workExperianceList);
                        rvWorkExp.setAdapter(workExperienceAdapter);

                        setTextForHtml(binding.tvApps,mResume.getData().getOtherSummery().getApps());
                        setTextForHtml(binding.tvHealthNamo,mResume.getData().getOtherSummery().getSummery().getHealthNamo());
                        setTextForHtml(binding.tvFieldFoster,mResume.getData().getOtherSummery().getSummery().getFieldFoster());
                        setTextForHtml(binding.tvBxp,mResume.getData().getOtherSummery().getSummery().getBxp());
                        setTextForHtml(binding.tvPremium,mResume.getData().getOtherSummery().getSummery().getPremiumCare());
                    }catch (NullPointerException n)
                    {
                        n.printStackTrace();
                        Toast.makeText(getApplicationContext(),"Something Went Wrong",Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(int statusCode) {
                    progressDialogUtils.dismiss();
                    Toast.makeText(getApplicationContext(),"Something Went Wrong",Toast.LENGTH_LONG).show();
                }
            });
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No Internet Connections",Toast.LENGTH_LONG).show();
        }

        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId)
            {
                if(checkedId==R.id.chipPersonal)
                {
                    binding.personalinfo.setVisibility(View.VISIBLE);
                    binding.workExperience.setVisibility(View.GONE);
                    binding.otherInfo.setVisibility(View.GONE);
                    binding.education.setVisibility(View.GONE);
                }
                else if(checkedId==R.id.chipWork)
                {
                    binding.personalinfo.setVisibility(View.GONE);
                    binding.workExperience.setVisibility(View.VISIBLE);
                    binding.otherInfo.setVisibility(View.GONE);
                    binding.education.setVisibility(View.GONE);
                }
                else if(checkedId==R.id.chipOther)
                {
                    binding.personalinfo.setVisibility(View.GONE);
                    binding.workExperience.setVisibility(View.GONE);
                    binding.otherInfo.setVisibility(View.VISIBLE);
                    binding.education.setVisibility(View.GONE);
                }
                else if(checkedId==R.id.chipEducation)
                {
                    binding.personalinfo.setVisibility(View.GONE);
                    binding.workExperience.setVisibility(View.GONE);
                    binding.otherInfo.setVisibility(View.GONE);
                    binding.education.setVisibility(View.VISIBLE);
                }
                else
                {

                }

            }
        });
    }

    private void setTextForHtml(TextView textView,String text)
    {
        if (Build.VERSION.SDK_INT < 24)
        {
            textView.setText(Html.fromHtml(text));
        }
        else
        {
            textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
        }
    }
}