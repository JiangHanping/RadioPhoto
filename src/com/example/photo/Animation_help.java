package com.example.photo;


import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Animation_help implements OnClickListener {
	private Context context;
	private ImageView iv_main2;
	private ImageView iv_main1;
	private boolean Mark=false;
	public void stop()
	{
		this.Mark=false;
		init();
	}
	public void start()
	{
		this.Mark=true;
		init();
	}
	public void pause()
	{
		if(Mark)
		{
			stop();
		}
		else
		{
			start();
		}
	}
	int[] images={};
	/**
	 * 
	 * @param context
	 *            This
	 * @param images
	 *            图片数组
	 * @param iv_main2
	 *            ImageView ID
	 * @param iv_main1
	 *            ImageView ID
	 */
	private Animation TranslateanimationLt;
	private AlphaAnimation myAnimation_Alpha;
	private ScaleAnimation myAnimation_Scale_Big;
	private ScaleAnimation myAnimation_Scale_Smal;
	private AnimationSet animationBig;
	private AnimationSet animationSmal;
	private int total=0;
	
	
	private TranslateAnimation TranslateanimationRt;
	private AnimationSet animationRt;
	private TranslateAnimation TranslateanimationLb;
	private TranslateAnimation TranslateanimationRb;
	private AnimationSet animationRb;
	private AnimationSet animationLt;
	private AnimationSet animationLb;
	private ScaleAnimation myAnimation_Scale_AllBig;
	Handler handlea=new Handler(new Callback()
	{

		@Override
		public boolean handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch(msg.what)
			{
			case 1:
				if(total>images.length)
				{
					total=0;
				}
				anima();
				String a=String.valueOf((int)(Math.random()*6+1));
				int Number=Integer.parseInt(a);
				if(Mark)
				{
					iv_main2.bringToFront();
					iv_main2.setImageResource(images[total]);
					total++;
					switch(Number)
					{
						case 1:
							iv_main2.setAnimation(animationSmal);
							break;
						case 2:
							iv_main2.setAnimation(animationBig);
							break;
						case 3:
							iv_main2.setAnimation(animationRt);
							break;
						case 4:
							iv_main2.setAnimation(TranslateanimationRb);
							break;
						case 5:
							iv_main2.setAnimation(animationLb);
							break;
						case 6:
							iv_main2.setAnimation(animationLt);
							break;
						default:
								break;	
					}
				}
				if(Mark)
				{
					handlea.sendEmptyMessageDelayed(2, 4500);	
				}
				break;
			case 2:
				if(Mark)
				{
					init();
				}
				break;
				default:
					break;
			}
			return false;
		}	
	});
	private void init() {
		iv_main2.setOnClickListener(this);
		iv_main1.setOnClickListener(this);

		if (total >= images.length) {
			total = 0;
		}
		anima();
		String a = String.valueOf((int) (Math.random() * 6 + 1));
		int Number = Integer.parseInt(a);
		if (Mark) {
			iv_main1.bringToFront();
			iv_main1.setImageResource(images[total]);
			total++;
			switch (Number) {
			case 1:
				iv_main1.setAnimation(animationSmal);
				break;
			case 2:
				iv_main1.setAnimation(animationBig);
				break;
			case 3:
				iv_main1.setAnimation(animationRt);
				break;
			case 4:
				iv_main1.setAnimation(animationRb);
				break;
			case 5:
				iv_main1.setAnimation(animationLb);
				break;
			case 6:
				iv_main1.setAnimation(animationLt);
				break;
			default:
				break;
			}
		} else {
			iv_main1.setBackgroundResource(images[total]);
		}
		if (Mark) {
			handlea.sendEmptyMessageDelayed(1, 4500);//消息延迟发送
		} else {
			Log.e("TAG", "Init2()------>" + Mark);
		}
	}
	private void anima() {
		// 透明
		myAnimation_Alpha = new AlphaAnimation(0f, 1f);
		myAnimation_Alpha.setDuration(2000);
		myAnimation_Alpha.setFillAfter(true);
		// 缩放 缩小
		myAnimation_Scale_Smal = new ScaleAnimation(1.6f, 1.2f, 1.6f, 1.2f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		myAnimation_Scale_Smal.setDuration(5000);
		myAnimation_Scale_Smal.setFillAfter(true);
		// 缩放 放大
		myAnimation_Scale_Big = new ScaleAnimation(1.2f, 1.6f, 1.2f, 1.6f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		myAnimation_Scale_Big.setDuration(5000);
		myAnimation_Scale_Big.setFillAfter(true);
		// 放大动画
		animationBig = new AnimationSet(true);
		animationBig.addAnimation(myAnimation_Scale_Big);
		animationBig.addAnimation(myAnimation_Alpha);
		animationBig.setFillAfter(true);
		// 缩小
		animationSmal = new AnimationSet(true);
		animationSmal.addAnimation(myAnimation_Scale_Smal);
		animationSmal.addAnimation(myAnimation_Alpha);
		animationSmal.setFillAfter(true);
		// 缩放 缩小
		myAnimation_Scale_AllBig = new ScaleAnimation(1.5f, 1.5f, 1.5f, 1.5f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		myAnimation_Scale_Smal.setDuration(5000);
		myAnimation_Scale_Smal.setFillAfter(true);
		// 右上
		TranslateanimationRt = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.05f,
				Animation.RELATIVE_TO_PARENT, 0.05f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		TranslateanimationRt.setDuration(5000);
		TranslateanimationRt.setFillAfter(true);
		animationRt = new AnimationSet(true);
		animationRt.addAnimation(TranslateanimationRt);
		animationRt.addAnimation(myAnimation_Scale_AllBig);
		animationRt.addAnimation(myAnimation_Alpha);
		animationRt.setFillAfter(true);
		// 左下
		TranslateanimationLb = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.05f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.05f);
		TranslateanimationLb.setDuration(5000);
		TranslateanimationLb.setFillAfter(true);
		animationLb = new AnimationSet(true);
		animationLb.addAnimation(TranslateanimationLb);
		animationLb.addAnimation(myAnimation_Scale_AllBig);
		animationLb.addAnimation(myAnimation_Alpha);
		animationLb.setFillAfter(true);

		// 右下
		TranslateanimationRb = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, -0.05f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -0.05f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		TranslateanimationRb.setDuration(5000);
		TranslateanimationRb.setFillAfter(true);
		animationRb = new AnimationSet(true);
		animationRb.addAnimation(TranslateanimationRb);
		animationRb.addAnimation(myAnimation_Scale_AllBig);
		animationRb.addAnimation(myAnimation_Alpha);
		animationRb.setFillAfter(true);

		// 左上
		TranslateanimationLt = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -0.05f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -0.05f);
		TranslateanimationLt.setDuration(5000);
		TranslateanimationLt.setFillAfter(true);
		animationLt = new AnimationSet(true);
		animationLt.addAnimation(TranslateanimationLt);
		animationLt.addAnimation(myAnimation_Scale_AllBig);
		animationLt.addAnimation(myAnimation_Alpha);
		animationLt.setFillAfter(true);
	}

	public Animation_help(Context context, ImageView iv_main2, ImageView iv_main1, int[] images) {
		super();
		this.context = context;
		this.iv_main2 = iv_main2;
		this.iv_main1 = iv_main1;
		this.images = images;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==iv_main2)
		{
			this.pause();
		}
		if(v==iv_main1)
		{
			this.pause();
		}

	}

}
