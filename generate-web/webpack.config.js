/**
 * Created by mac on 16/7/14.
 */
var webpack = require('webpack');
var path = require('path');

module.exports = {
    //页面入口文件配置
    entry: {
        index: [
            // 开启react代码的模块热替换（HMR）
            'react-hot-loader/patch',
        // 为webpack-dev-server的环境打包好运行代码
        // 然后连接到指定服务器域名与端口, 这里的端口为自己项目的端口
                    'webpack-dev-server/client?http://localhost:3000/',
        // 为热替换（HMR）打包好运行代码
        // only- 意味着只有成功更新运行代码才会执行热替换（HMR）
                    'webpack/hot/only-dev-server',
        ]
    },
    //入口文件输出配置
    output: {
        path: __dirname + '/assets/',
        filename: 'bundle.js'
    },
    module: {
        //加载器配置
        loaders: [
            {
                test: /\.css$/,
                loader: 'style-loader!css-loader'
            },

            {
                test: /\.js$/,
                loader: 'jsx-loader?harmony'
            },
            {
                test: /\.(png|jpg)$/,
                loader: 'url-loader?limit=8192'
            },
            {
                test: /\.js|jsx$/,
                loaders: ['react-hot', 'babel?presets[]=es2015,presets[]=react,presets[]=stage-0'],
                include: path.join(__dirname, 'js')
            }
        ]
    },
    //其它解决方案配置
    resolve: {
        extensions: ['', '.js', '.json', '.scss']
    },
    //插件项
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new webpack.NoErrorsPlugin()
    ]
};