package com.truonghd.productdiscovery.view.adapter.implement;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Truong.HanDang on 2019-07-17
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class RecyclerBaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    protected static final int GONE = 0;
    protected static final int VISIBLE = 1;
    private static final int HEADER = 0xf0;
    private static final int BODY = 0xf1;
    private static final int FOOTER = 0xf2;
    private int mFlagHeaderVisibility = 0;
    private int mFlagFooterVisibility = 0;
    private boolean mFlagAttachedToRecyclerView = false;

    @Override
    public final int getItemViewType(int position) {
        if (position == 0 && mFlagHeaderVisibility == VISIBLE) {
            return HEADER;
        }
        if (position == getItemCount() - 1 && mFlagFooterVisibility == VISIBLE) {
            return FOOTER;
        }
        return getContentViewType(position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER:
                return onCreateHeaderHolder(parent);
            case FOOTER:
                return onCreateFooterHolder(parent);
            case BODY:
            default:
                return onCreateContentHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBindView(position);
    }

    public int getItemPosition(@NonNull BaseViewHolder holder) {
        int mLayoutPosition = holder.getLayoutPosition();
        if (mLayoutPosition == RecyclerView.NO_POSITION) {
            return RecyclerView.NO_POSITION;
        }
        return toContentPosition(mLayoutPosition);
    }

    @Override
    public final int getItemCount() {
        return mFlagFooterVisibility + mFlagHeaderVisibility + getContentItemCount();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        mFlagAttachedToRecyclerView = true;
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mFlagAttachedToRecyclerView = false;
    }

    /**
     * position content view item
     *
     * @param position position item
     * @return position content
     */
    public int toContentPosition(int position) {
        return position - mFlagHeaderVisibility;
    }

    /**
     * get content view type
     *
     * @param position position view item
     * @return view type
     */
    public int getContentViewType(int position) {
        return BODY;
    }

    /**
     * get total content item
     *
     * @return int
     */
    public abstract int getContentItemCount();

    /**
     * create header holder
     *
     * @param parent view parent
     * @return holder view
     */
    public abstract BaseViewHolder onCreateHeaderHolder(ViewGroup parent);

    /**
     * create footer holder
     *
     * @param parent view parent
     * @return holder view
     */
    public abstract BaseViewHolder onCreateFooterHolder(ViewGroup parent);

    /**
     * create content holder
     *
     * @param parent   view parent
     * @param viewType view type
     * @return holder view
     */
    public abstract BaseViewHolder onCreateContentHolder(ViewGroup parent, int viewType);

    /**
     * check recycler view is attach in view or not
     *
     * @return true: recycler view is attached, false: recycler view isn't attach
     */
    public boolean isAttachedToRecyclerView() {
        return mFlagAttachedToRecyclerView;
    }

    /**
     * update item header
     */
    public void notifyHeaderChanged() {
        if (mFlagHeaderVisibility == VISIBLE) {
            notifyItemChanged(0);
        }
    }

    /**
     * update item footer
     */
    public void notifyFooterChanged() {
        if (mFlagFooterVisibility == VISIBLE) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    /**
     * show/hide header footer view
     *
     * @param visibility true: show, false: hide
     */
    public void setFooterVisibility(boolean visibility) {
        int newValue = visibility ? VISIBLE : GONE;
        if (newValue != this.mFlagFooterVisibility) {
            mFlagFooterVisibility = newValue;
            if (mFlagAttachedToRecyclerView) {
                switch (mFlagFooterVisibility) {
                    case VISIBLE:
                        notifyItemInserted(getItemCount() - 1);
                        break;
                    case GONE:
                        notifyItemRemoved(getItemCount() - 1);
                }
            }
        }
    }

    /**
     * show/hide header recycler view
     *
     * @param visibility true: show, false: hide
     */
    public void setHeaderVisibility(boolean visibility) {
        int newValue = visibility ? VISIBLE : GONE;
        if (newValue != this.mFlagHeaderVisibility) {
            mFlagHeaderVisibility = newValue;
            if (mFlagAttachedToRecyclerView) {
                switch (mFlagHeaderVisibility) {
                    case VISIBLE:
                        notifyItemInserted(0);
                        break;
                    case GONE:
                        notifyItemRemoved(0);
                }
            }
        }
    }

    public <VB extends ViewDataBinding> VB createBinding(@NonNull ViewGroup parent,
                                                         @LayoutRes int resLayoutId) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return DataBindingUtil.inflate(inflater, resLayoutId, parent, false);
    }
}
