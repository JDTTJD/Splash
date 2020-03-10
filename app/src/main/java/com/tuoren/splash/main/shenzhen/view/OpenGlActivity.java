package com.tuoren.splash.main.shenzhen.view;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.tuoren.opengl.OpenGlManger;
import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseActivity;
import com.tuoren.splash.base.ViewInject;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import butterknife.BindView;
import butterknife.ButterKnife;

@ViewInject(mainlayoutid = R.layout.activity_open_gl)
public class OpenGlActivity extends BaseActivity {
    @BindView(R.id.gl_surface_view)
    GLSurfaceView glSurfaceView;

    @Override
    public void afterBindView() {
        glSurfaceView.setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                //为缓冲区设置清除颜色的值 相当于初始化。
//                gl.glClearColor(0.0f,0.0f,1.0f,1.0f);
                OpenGlManger.onSurfaceCreated();
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int width, int height) {
                //设置 视图 大小
//                gl.glViewport(0,0, width, height);
                OpenGlManger.onSurfaceChanged(width, height);
            }

            //每一帧绘制时都会被系统调用 在android中 默认最高绘制效率为1秒60帧
            @Override
            public void onDrawFrame(GL10 gl) {
                // 设置色彩
//                gl.glClear(gl.GL_COLOR_BUFFER_BIT);
                OpenGlManger.onDrawFrame();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
