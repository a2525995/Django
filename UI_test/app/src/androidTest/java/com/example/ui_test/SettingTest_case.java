package com.example.ui_test ;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;

import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.support.test.uiautomator.Until;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.util.Log;
import android.view.KeyEvent;

import com.example.ui_test.utils.Constant;

;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class SettingTest_case {

    public final String TAG = getClass().getSimpleName();
    private static final String popop = "13677598456";
    private static final String BASIC_SIMPLE_PACKAGE
            = Constant.PACKAGE_SETTING;
    private static final long LAUNCH_TIMEOUT = 10000L;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice mDevice = null;
    private Context mContext = null;
    public Instrumentation instrumentation;

    String APP = "Setting";

    @Before
    public void setUP() throws RemoteException,InterruptedException{
        mDevice  = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());//Initialize UiDevice instance

        instrumentation = InstrumentationRegistry.getInstrumentation();

        //If screen off,Wake it up
        try {
            if (!mDevice.isScreenOn()) {
                mDevice.wakeUp();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //If device has some app still run , All of them will be destroy
        mDevice.pressRecentApps();
        mDevice.wait(Until.hasObject(By.res("com.android.systemui:id/button")),LAUNCH_TIMEOUT);
        UiObject2 rentapp = mDevice.findObject(By.res("com.android.systemui:id/button"));
        if (rentapp!=null){
            rentapp.click();
            //To
            Thread.sleep(2000);
        }

        //Press home key
        mDevice.pressHome();



    }
    @Test
    public void test_case1() throws UiObjectNotFoundException,InterruptedException,RemoteException{
        //obtain the context of test-package
        Bundle args = InstrumentationRegistry.getArguments();
        instrumentation.sendStatus(100,args);
        mContext = InstrumentationRegistry.getContext();
        Context testedContext = InstrumentationRegistry.getTargetContext();


        final String launcherPackage = mDevice.getLauncherPackageName();
        if (launcherPackage != null) {
            mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);



            //wait for launch

//            final Intent intent =mContext.getPackageManager().getLaunchIntentForPackage(BASIC_SIMPLE_PACKAGE);
//            //if there are old activity in moment,all of them will be cleared
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//
//            mContext.startActivity(intent);
//            mDevice.wait(Until.hasObject(By.pkg(BASIC_SIMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
//            UiObject AAP = mDevice.findObject(new UiSelector().text("外观"));
//
//            AAP.click();
//            mDevice.setOrientationRight();

            Intent intent5 = mContext.getPackageManager().getLaunchIntentForPackage("com.sonymobile.android.contacts");
            intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            mContext.startActivity(intent5);
            mDevice.wait(Until.hasObject(By.res("com.android.contacts:id/floating_action_button")),LAUNCH_TIMEOUT);
            UiObject2 iij = mDevice.findObject(By.res("com.android.contacts:id/floating_action_button"));
            iij.click();
            Thread.sleep(2000);
            List<UiObject2> krffi = mDevice.findObject(By.res("com.android.contacts:id/editors")).getChildren();
            Random rand = new Random();
            krffi.get(1).setText("66666");
            Thread.sleep(2000);
            mDevice.wakeUp();


//            Intent intent7 = mContext.getPackageManager().getLaunchIntentForPackage("com.sonyericsson.organizer");
//            intent7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            mContext.startActivity(intent7);
//            mDevice.wait(Until.hasObject(By.res("com.sonyericsson.organizer:id/smart_fab")),LAUNCH_TIMEOUT);
//            UiObject2 jfk = mDevice.findObject(By.res("com.sonyericsson.organizer:id/smart_fab"));
//            jfk.click();



//            mDevice.registerWatcher("UIWatcher", new UiWatcher() {
//                @Override
//                public boolean checkForCondition() {
//                    UiObject2 ui = mDevice.findObject(By.res("com.android.packageinstaller:id/permission_allow_button"));
//                    if (mDevice.hasObject(By.res("com.android.packageinstaller:id/permission_allow_button"))){
//                        ui.click();
//                        Log.d(TAG,"it has been triggered!");
//                        return true;
//                    }
//                    else
//
//                        Log.d(TAG,"it doesn't work-----------------------------------------------------");
//                    return false;
//                }
//            });
//
//
//            Intent intent8 = mContext.getPackageManager().getLaunchIntentForPackage("com.sonyericsson.album");
//            intent8.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            mContext.startActivity(intent8);
//            Thread.sleep(4000);
//            mDevice.wait(Until.hasObject(By.res("com.android.packageinstaller:id/permission_allow_button")),LAUNCH_TIMEOUT);
//            mDevice.findObject(By.res("sdfjfhdsfsdf"));

//            ui.click();





//
//            mDevice.pressHome();
//
//            Intent intent3 = mContext.getPackageManager().getLaunchIntentForPackage("com.sonymobile.android.dialer");
//            intent3.addFlags(intent3.FLAG_ACTIVITY_CLEAR_TASK);
//            mDevice.wait(Until.hasObject(By.pkg("com.sonymobile.android.dialer").depth(0)),LAUNCH_TIMEOUT);
//            mContext.startActivity(intent3);
//            mDevice.wait(Until.hasObject(By.res("com.android.dialer:id/floating_action_button")),LAUNCH_TIMEOUT);
//            UiObject2 aas = mDevice.findObject(By.res("com.android.dialer:id/floating_action_button"));
//            aas.click();
//            mDevice.wait(Until.hasObject(By.res("com.android.dialer:id/dialpad_floating_action_button")),LAUNCH_TIMEOUT);
//            for(int i=0;i<popop.length();i++){
//                char k = popop.charAt(i);
//                switch (k){
//                    case'1':
//                        APP = "com.android.dialer:id/one";break;
//                    case'2':
//                        APP = "com.android.dialer:id/two";break;
//                    case'3':
//                        APP = "com.android.dialer:id/three";break;
//                    case'4':
//                        APP = "com.android.dialer:id/four";break;
//                    case'5':
//                        APP = "com.android.dialer:id/five";break;
//                    case'6':
//                        APP = "com.android.dialer:id/six";break;
//                    case'7':
//                        APP = "com.android.dialer:id/seven";break;
//                    case'8':
//                        APP = "com.android.dialer:id/eight";break;
//                    case'9':
//                        APP = "com.android.dialer:id/nine";break;
//                    case'0':
//                        APP = "com.android.dialer:id/zero";break;
//
//
//                }
//                mDevice.findObject(By.res(APP)).click();
//
//            }
//            UiObject2 yyj = mDevice.findObject(By.res("com.android.dialer:id/digits"));
//            assertEquals("1 367-759-8456",yyj.getText());




//            Intent  intent2 = mContext.getPackageManager().getLaunchIntentForPackage("com.google.android.googlequicksearchbox");
//            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            mContext.startActivity(intent2);
//
//            mDevice.wait(Until.hasObject(By.res("com.google.android.googlequicksearchbox:id/text_container")),LAUNCH_TIMEOUT);
//            UiObject2 oko = mDevice.findObject(By.res("com.google.android.googlequicksearchbox:id/text_container"));
//            oko.click();
//            mDevice.wait(Until.hasObject(By.res("com.google.android.googlequicksearchbox:id/search_box")),LAUNCH_TIMEOUT);
//            UiObject2 kko = mDevice.findObject(By.res("com.google.android.googlequicksearchbox:id/search_box"));
//            kko.setText("com.g");
//
//
//            mDevice.pressEnter();


//            Intent intent1 = mContext.getPackageManager().getLaunchIntentForPackage("com.sonymobile.exactcalculator");
//            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            mContext.startActivity(intent1);
//            mDevice.wait(Until.hasObject(By.pkg("com.sonymobile.exactcalculator").depth(0)), LAUNCH_TIMEOUT);
//            mDevice.findObject(new UiSelector().text("2")).click();
//            UiObject2 result = mDevice.findObject(By.res("com.sonymobile.exactcalculator:id/formula"));
//




        }


    }
}
