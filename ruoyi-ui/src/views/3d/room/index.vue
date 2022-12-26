<template>
  <div class="app-container ">
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

export default {
  name: "Scene",
  data: function () {
    return {
      scene: undefined,
      renderer: undefined,
      camera: undefined,
      loaded: 0
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

      this.$refs.scene.appendChild(this.renderer.domElement)

      // Camera
      const aspect = this.$refs.scene.clientWidth / this.$refs.scene.clientHeight
      this.camera = new THREE.PerspectiveCamera(50, aspect, 0.1, 5000)
      this.camera.position.set(0.5, 0.5, 4)
      this.camera.rotation.y = (150 / 180) * Math.PI

      new OrbitControls(this.camera, this.renderer.domElement); //创建控件对象

      const loader = new GLTFLoader()
      console.log(loader)
      loader.load("/module/modern_dining_room/scene.gltf", (gltf) => {
        console.log(this)
        this.scene.add(gltf.scene)
        gltf.scene.traverse(function (child) {
          if (child.isMesh) {
            child.material.emissive = child.material.color;
            child.material.emissiveMap = child.material.map;
          }
        });
        this.animate()
      }, xhr => {
        this.loaded = Math.floor(xhr.loaded / xhr.total * 100)
      })

    },
    animate() {
      this.render()
      requestAnimationFrame(this.animate)
    },
    render() {
      //执行渲染操作
      this.renderer.render(this.scene, this.camera);
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
