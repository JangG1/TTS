module.exports = {
  outputDir: '../src/main/resources/static',
  devServer: {
      port: 9000,
      proxy: {
          "/api": {
              target: "http://localhost:8085",
              changeOrigin: true,
              logLevel: "debug",
              secure : false
          }
      }
  }
}

