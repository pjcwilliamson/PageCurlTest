package org.williamsonministry.pagecurltest;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class BookFlipPageTransformerEdit implements ViewPager.PageTransformer {
    private final int CAMERA_DISTANCE = -12000;
    private final int LEFT = -1;
    private final int RIGHT = 1;
    private final int CENTER = 0;
    private float scaleAmountPercent = 5f;
    private boolean enableScale = false;

    // TODO: 5/15/2022 Look here: https://medium.com/android-news/creating-an-intro-screen-for-your-app-using-viewpager-pagetransformer-9950517ea04f 

    @Override
    public void transformPage(@NonNull View page, float position) {
        View rightView = page.findViewById(R.id.layoutRight);
        View leftView = page.findViewById(R.id.layoutLeft);
        // TODO: 5/14/2022 Make left view stay still... for now
        float percentage = 1 - Math.abs(position);
        // Don't move pages once they are on left or right
        if (position >= CENTER && position <= RIGHT)
        {
            // This is behind page
            rightView.setTranslationX(-position * (rightView.getWidth()+leftView.getWidth()));
            rightView.setTranslationY(0);
            rightView.setRotation(0);
            //rightView.setVisibility(View.VISIBLE);

            //Still vry much got to work on this
            reverseFlipPage(leftView, position, percentage);

            leftView.setTranslationX(-position * (rightView.getWidth()+leftView.getWidth()));
            leftView.setTranslationY(0);
            leftView.setRotation(0);

            if (enableScale)
            {
                float amount = ((100 - scaleAmountPercent) + ( scaleAmountPercent * percentage)) / 100;
                setSize(page, position, amount);
            }
        }
        // Otherwise flip the current page
        else
        {
            rightView.setVisibility(View.VISIBLE);
            leftView.setVisibility(View.VISIBLE);
            flipPage(rightView, position, percentage);
            stopPage(leftView, position, percentage);
        }
    }

    private void reverseFlipPage(View page, float position, float percentage) {
        page.setCameraDistance(CAMERA_DISTANCE);
        setVisibility(page,-position);
        setTranslation(page);
        setPivot(page, page.getWidth(), page.getHeight() * 0.5f);
        setRotation(page, position, percentage);
    }

    private void stopPage(View page, float position, float percentage)  {
        ViewPager viewPager = (ViewPager) page.getParent().getParent();
        int scroll = viewPager.getScrollX();
        page.setTranslationX(scroll);

    }

    private void flipPage(View page, float position, float percentage)
    {
        // Flip this page
        page.setCameraDistance(CAMERA_DISTANCE);
        setVisibility(page, position);
        setTranslation(page);
        setPivot(page, 0, page.getHeight() * 0.5f);
        setRotation(page, position, percentage);
    }

    private void setPivot(View page, float pivotX, float pivotY)
    {
        page.setPivotX(pivotX);
        page.setPivotY(pivotY);
    }

    private void setVisibility(View page, float position) {
        if (position < 0.5 && position > -0.5) {
            page.setVisibility(View.VISIBLE);
        } else {
            page.setVisibility(View.INVISIBLE);
        }
    }

    private void setTranslation(View page) {
        ViewPager viewPager = (ViewPager) page.getParent().getParent();
        int scroll = viewPager.getScrollX() - page.getLeft();
        page.setTranslationX(scroll+page.getWidth());
    }

    private void setSize(View page, float position, float percentage) {
        page.setScaleX((position != 0 && position != 1) ? percentage : 1);
        page.setScaleY((position != 0 && position != 1) ? percentage : 1);
    }

    private void setRotation(View page, float position, float percentage) {
        if (position > 0) {
            page.setRotationY(-180 * (percentage + 1));
        } else {
            page.setRotationY(180 * (percentage + 1));
        }
    }
    public float getScaleAmountPercent() {
        return scaleAmountPercent;
    }

    public void setScaleAmountPercent(float scaleAmountPercent) {
        this.scaleAmountPercent = scaleAmountPercent;
    }

    public boolean isEnableScale() {
        return enableScale;
    }

    public void setEnableScale(boolean enableScale) {
        this.enableScale = enableScale;
    }
}
