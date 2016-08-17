# AndroidRevealHelper
Helper to circle reveal/unreveal a view easily

### Preview 
<img src="https://github.com/WideWebMobile/AndroidRevealHelper/blob/master/preview/revealator.gif" width="30%">

### Repository

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

### Dependency

Add this to your module's `build.gradle` file:

```gradle
dependencies {
    ...
    compile 'com.github.WideWebMobile:AndroidRevealHelper:2.0.2'
}
```
### How to use:

Just put the view you want to animate in a `io.codetail.widget.RevealFrameLayout`:
```
 <io.codetail.widget.RevealFrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <View
            android:id="@+id/main_reveal_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#FFFFFF"
            android:visibility="invisible" />
    </io.codetail.widget.RevealFrameLayout>
    
    <android.support.v7.widget.AppCompatButton
        android:id="@+id/main_reveal_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|start"
        android:layout_margin="16dp"
        android:background="#FF5722"
        android:text="Reveal"
        android:textAppearance="@style/TextAppearance.AppCompat.Widget.Button"
        android:textColor="#FFFFFF" />

    <android.support.v7.widget.AppCompatButton
        android:id="@+id/main_unreveal_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_margin="16dp"
        android:background="#FF5722"
        android:text="Unreveal"
        android:textAppearance="@style/TextAppearance.AppCompat.Widget.Button"
        android:textColor="#FFFFFF" />
```
and use the Revealator's magic to reveal or unreveal:

```
mRevealButton = (AppCompatButton) findViewById(R.id.main_reveal_button);
mUnrevealButton = (AppCompatButton) findViewById(R.id.main_unreveal_button);
mRevealView = findViewById(R.id.main_reveal_view);
```
and then
```
 Revealator.revealView(mRevealView)
                        .targetView(mRevealButton)
                        .setRevealPosition(RevealPosition.CENTER)
                        .setDuration(450)
                        .startReveal();
```
or
```
Revealator.revealView(mRevealView)
                        .targetView(mUnrevealButton)
                        .setRevealPosition(RevealPosition.CENTER)
                        .setDuration(450)
                        .startUnreveal();
```
All features:
```
 Revealator.revealView( revealView )
                .targetView( targetView )
                .setRevealPosition( revealPosition )      // RevealPosition.CENTER - default
                .setDelay( long delay )                   // 0 - default
                .setDuration( long duration )             // 450 - default
                .onEndCallback(new RevealListener() {
                    @Override
                    public void onEndAnimation() {
                        **your code here**
                    }
                })
                .startReveal();                           // or .startUnreveal();
```

### References

This project uses [ozodrukh's CircularReveal](https://github.com/ozodrukh/CircularReveal) for Android 4 compatibility.

### License 

 ```code
Copyright 2016 Mikhail "MikoBlaiz" Kontsevoi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.```
