<template>
  <div class="app-container ">
    <!--    <script type="module" src="https://unpkg.com/@google/model-viewer/dist/model-viewer.min.js"></script>-->
    <!--    <model-viewer src="/module/logo/scene.glb" ar ar-modes="webxr scene-viewer quick-look" camera-controls-->
    <!--                  poster="poster.webp" shadow-intensity="1" _msthidden="1" modelCacheSize="200">-->
    <!--    </model-viewer>-->

    <div v-show="loaded < 100" style="text-align: center">
      <el-progress type="circle" :percentage="loaded"></el-progress>
    </div>

    <div class="scene" ref="scene" height="100px">

    </div>


  </div>
</template>

<script>
import * as THREE from "three"
import {OrbitControls} from "three/examples/jsm/controls/OrbitControls"
import {GLTFLoader} from "three/examples/jsm/loaders/GLTFLoader"
import {RGBELoader} from "three/examples/jsm/loaders/RGBELoader";


export default {
  name: "Scene",
  data: function () {
    return {
      scene: undefined,
      renderer: undefined,
      camera: undefined,
      loaded: 0,
    };
  },
  methods: {
    init() {

      /**
       * 创建场景对象Scene
       */
      this.scene = new THREE.Scene();
      this.scene.background = new THREE.Color(0xffffff)

      // Renderer
      this.renderer = new THREE.WebGLRenderer({antialias: true})
      this.renderer.physicallyCorrectLights = true;
      this.renderer.setSize(this.$refs.scene.clientWidth, this.$refs.scene.clientHeight)
      this.renderer.setPixelRatio(window.devicePixelRatio);
      this.renderer.gammaOutput = true;
      this.renderer.shadowMap.enabled = true;
      this.renderer.toneMapping = THREE.ACESFilmicToneMapping;
      this.renderer.outputEncoding = THREE.sRGBEncoding
      this.renderer.toneMappingExposure = 2.2;
      this.$refs.scene.appendChild(this.renderer.domElement)

      new RGBELoader().load("/textures/equirectangular/sky.hdr", texture => {
        // console.log("@@@@@@@", texture)
        const gen = new THREE.PMREMGenerator(this.renderer)
        const envMap = gen.fromEquirectangular(texture).texture
        this.scene.environment = envMap
        this.scene.background = envMap
        texture.dispose()
        gen.dispose()
        const loader = new GLTFLoader()
        loader.load("/module/logo/scene.gltf", (result) => {
          this.scene.add(result.scene)
          this.animate()
        }, xhr => {
          this.loaded = Math.floor(xhr.loaded / xhr.total * 100)
        })
      })
      // Camera
      const aspect = this.$refs.scene.clientWidth / this.$refs.scene.clientHeight
      this.camera = new THREE.PerspectiveCamera(50, aspect, 0.1, 500)
      this.camera.position.set(3, 3, 7)


      this.camera.rotation.y = (150 / 180) * Math.PI
      new OrbitControls(this.camera, this.renderer.domElement); //创建控件对象


    },
    animate() {
      this.renderer.render(this.scene, this.camera); //执行渲染操作
      requestAnimationFrame(this.animate)
    }
  },
  mounted() {
    this.init()

  }

}
</script>


<style>
.scene {
  width: 100%;
  height: 0;
  padding-bottom: 50%;
}

.w-20 {
  width: 20%;
}

.h-small {
  height: 10px;
}

@media (max-width: 992px) {
  .scene {
    width: 100%;
    height: 0;
    padding-bottom: 0;
  }
}
</style>
