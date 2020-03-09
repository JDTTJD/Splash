package com.tuoren.splash.main.shenzhen;

import android.opengl.GLSurfaceView;

import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseFragment;
import com.tuoren.splash.base.ViewInject;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import butterknife.BindView;

/**
 * Create by JDT on 2019/11/8.
 */
@ViewInject(mainlayoutid = R.layout.fragment_shenzhen)
public class ShenZhenFragment extends BaseFragment {
    @BindView(R.id.gl_surface_view)
    GLSurfaceView glSurfaceView;

    @Override
    public void afterBindView() {
        glSurfaceView.setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                //为缓冲区设置清除颜色的值 相当于初始化
                gl.glClearColor(0.0f,0.0f,1.0f,1.0f);
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int width, int height) {
                //设置 视图 大小
                gl.glViewport(0,0, width, height);
            }

            //每一帧绘制时都会被系统调用 在android中 默认最高绘制效率为1秒60帧
            @Override
            public void onDrawFrame(GL10 gl) {
                // 设置色彩
                gl.glClear(gl.GL_COLOR_BUFFER_BIT);
            }
        });
    }

}
