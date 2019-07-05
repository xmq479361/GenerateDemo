// 导航栏的选项可以被定义为屏幕属性的函数
static navigationOptions = ({navigation}) => {
    //${navigation.state.params.user} 是一个动态的参数，参数名为user
    return createCommonTopBarNavigationOptions({
        navigation,
        headTitle: {{title}},
        {% for key, value in attrs %}{% if value and value != '' %}{{'\n\t'+key}}: {{value}}{% endif %}{% endfor %}
    })
};