package com.ssba.adapter;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ssba.R;
import com.ssba.databinding.LayoutWorkExperienceBinding;
import com.ssba.model.WorkExperiance;

import java.util.ArrayList;
import java.util.List;

public class WorkExperienceAdapter extends RecyclerView.Adapter<WorkExperienceAdapter.ViewHolder>{
    private List<WorkExperiance> mWorkExperiances;
    private Context context;

    public WorkExperienceAdapter(Context context,List<WorkExperiance> mWorkExperiances)
    {
        this.context=context;
        this.mWorkExperiances=mWorkExperiances;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutWorkExperienceBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.layout_work_experience, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        LayoutWorkExperienceBinding binding = holder.binding;

        if (Build.VERSION.SDK_INT < 24)
        {
            binding.tvProjectName.setText(Html.fromHtml(mWorkExperiances.get(position).getProjectName()));
            binding.tvOrganization.setText(Html.fromHtml(mWorkExperiances.get(position).getOrganization()));
            binding.tvTeamSize.setText(Html.fromHtml(mWorkExperiances.get(position).getTeamSize()));
            binding.tvRoles.setText(Html.fromHtml(mWorkExperiances.get(position).getRoles()));
            binding.tvContribution.setText(Html.fromHtml(mWorkExperiances.get(position).getContribution()));
            binding.tvAchivements.setText(Html.fromHtml(mWorkExperiances.get(position).getAchivements()));
            if(!mWorkExperiances.get(position).getProjectDescription().getDownloads().equals(""))
            {
                binding.tvDownloads.setText(Html.fromHtml(mWorkExperiances.get(position).getProjectDescription().getDownloads()));
                binding.tvLink.setText(Html.fromHtml(mWorkExperiances.get(position).getProjectDescription().getLink()));
                binding.tvDescription.setText(Html.fromHtml(mWorkExperiances.get(position).getProjectDescription().getDescription()));
            }
            else
            {
                binding.tvDownloads.setVisibility(View.GONE);
                binding.tvLink.setVisibility(View.GONE);
                binding.tvDescription.setVisibility(View.GONE);
            }
        } else {
            binding.tvProjectName.setText(Html.fromHtml(mWorkExperiances.get(position).getProjectName(), Html.FROM_HTML_MODE_LEGACY));
            binding.tvOrganization.setText(Html.fromHtml(mWorkExperiances.get(position).getOrganization(), Html.FROM_HTML_MODE_LEGACY));
            binding.tvTeamSize.setText(Html.fromHtml(mWorkExperiances.get(position).getTeamSize(), Html.FROM_HTML_MODE_LEGACY));
            binding.tvRoles.setText(Html.fromHtml(mWorkExperiances.get(position).getRoles(),Html.FROM_HTML_MODE_LEGACY));
            binding.tvContribution.setText(Html.fromHtml(mWorkExperiances.get(position).getContribution(),Html.FROM_HTML_MODE_LEGACY));
            binding.tvAchivements.setText(Html.fromHtml(mWorkExperiances.get(position).getAchivements(),Html.FROM_HTML_MODE_LEGACY));

            if(!mWorkExperiances.get(position).getProjectDescription().getDownloads().equals(""))
            {
                binding.tvDownloads.setText(Html.fromHtml(mWorkExperiances.get(position).getProjectDescription().getDownloads(),Html.FROM_HTML_MODE_LEGACY));
                binding.tvLink.setText(Html.fromHtml(mWorkExperiances.get(position).getProjectDescription().getLink(),Html.FROM_HTML_MODE_LEGACY));
                binding.tvDescription.setText(Html.fromHtml(mWorkExperiances.get(position).getProjectDescription().getDescription(),Html.FROM_HTML_MODE_LEGACY));
            }
            else
            {
                binding.tvDownloads.setVisibility(View.GONE);
                binding.tvLink.setVisibility(View.GONE);
                binding.tvDescription.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mWorkExperiances.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutWorkExperienceBinding binding;

        ViewHolder(LayoutWorkExperienceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

