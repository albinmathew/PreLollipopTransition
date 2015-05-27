# PreLollipopTransition
Simple tool which help you to implement activity and fragment transition for pre-Lollipop devices.

[ ![Download](https://api.bintray.com/packages/albinmathew/maven/PreLollipopTransition/images/download.svg) ](https://bintray.com/albinmathew/maven/PreLollipopTransition/_latestVersion) [ ![Download](https://img.shields.io/github/release/albinmathew/PreLollipopTransition.svg?label=JitPack) ](https://jitpack.io/#albinmathew/PreLollipopTransition/1.1.0)

![prelollipopanimation](https://cloud.githubusercontent.com/assets/1386930/7614211/53ca12d8-f9d0-11e4-8b98-b6d98272f67d.gif)

## Download
In your app build.gradle add

```
	repositories {
	    maven {
	        url "https://jitpack.io"
	    }
	}
```

```
dependencies {
    compile 'com.albinmathew:pre-lollipop-activity-transition:1.1.0'
}
```

## Code
### Actvity
Start Activity in first activity.

```
findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final Intent intent = new Intent(MainActivity.this, SubActivity.class);
        ActivityTransitionLauncher.with(MainActivity.this).from(v).launch(intent);
    }
});
```

Receive intent in second activity.

```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ActivityTransition.with(getIntent()).to(findViewById(R.id.sub_imageView)).start(savedInstanceState);
    }
```

If you want the exit animation, you can do like this.
```
    private ExitActivityTransition exitTransition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        exitTransition = ActivityTransition.with(getIntent()).to(findViewById(R.id.sub_imageView)).start(savedInstanceState);
    }
    @Override
    public void onBackPressed() {
        exitTransition.exit(this);
    }
```

### Fragment
Start fragment transition in first activity.
```
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.support_fragment_start, container, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EndFragment toFragment = new EndFragment();
                FragmentTransitionLauncher
                        .with(view.getContext())
                        .image(BitmapFactory.decodeResource(getResources(), R.drawable.photo))
                        .from(view.findViewById(R.id.imageView)).prepare(toFragment);
                getFragmentManager().beginTransaction().replace(R.id.content, toFragment).addToBackStack(null).commit();
            }
        });
        return v;
    }
```

Start animation in second fragment.
```
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.support_fragment_end, container, false);
        final ExitFragmentTransition exitFragmentTransition = FragmentTransition.with(this).to(v.findViewById(R.id.fragment_imageView)).start(savedInstanceState);
        exitFragmentTransition.startExitListening();
        return v;
    }
```

## Thanks
Sample Photo
Luke Ma
https://www.flickr.com/photos/lukema/12499338274/in/photostream/

DevBytes: Custom Activity Animations
https://www.youtube.com/watch?v=CPxkoe2MraA

## License

This project is released under the Apache License, Version 2.0.

* [The Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)
