/* 
 * A video file needs to be pushed into a file.
 * Go into DDSM Perspective, File Explorer, push/pull buttons for memory.
 * Use Emulator from DOS Command Line to push/pull file.
 * This example uses a MediaController to start and stop video.
 * Tap on the VideoView to make controller visible.
 *
 * Emulator has regressions at API 24 and 25. Use API 23.
 */
package com.course.example;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.Toast;

public class Video extends Activity {

	VideoView video;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		video = (VideoView) findViewById(R.id.video);


		//set completion listener
		video.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				Toast.makeText(getApplicationContext(),
							  "Bravo! Bravo!", Toast.LENGTH_LONG).show();
			}
		});

		//create media controller for video
		MediaController mc = new MediaController(this);
		mc.setMediaPlayer(video);
		video.setMediaController(mc);

		//load the video
		String path = getFilesDir().toString() + "/samplevideo.3gp"  ;
		Uri videoUri = Uri.parse(path);
		video.setVideoURI(videoUri);

		mc.show();

	}
	
}
