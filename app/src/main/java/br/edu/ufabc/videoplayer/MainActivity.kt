package br.edu.ufabc.videoplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.ufabc.videoplayer.databinding.ActivityMainBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var player: ExoPlayer

    companion object {
        private const val mediaFile = "AndyYen_2014G-480p_small.webm"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        player = ExoPlayer.Builder(applicationContext).build()

        binding.styledPlayerView.player = player
        player.setMediaItem(MediaItem.fromUri(Uri.parse("asset:///$mediaFile")))
        player.prepare()
    }

    override fun onStop() {
        super.onStop()
        binding.styledPlayerView.player?.release()
    }
}