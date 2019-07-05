from com.xmq.react.Base import BaseWidget
from com.xmq.react.Container import ContainerWidget, do_generate_by_type
from com.xmq.react.ReactAttributes import AttrMapper


class AppBarWidget(ContainerWidget):
    def __init__(self, data, config):
        BaseWidget.__init__(self, data, config)
        self.attribute_mapper.append(ReactAttrMapperAppBarTitle())
        self.attribute_mapper.append(ReactAttrMapperAppBarLeft())
        self.attribute_mapper.append(ReactAttrMapperAppBarRight())

    def render_name(self):
        return "action_bar.js"

    def generate(self, parent_direction, curr_direction=None):
        self.attribute_mapper.mapper(self.data, self.config)
        # TODO 获取组件各种样式属性
        attrs = self.config.get_attributes()
        styles = self.config.get_styles()
        print("AppBar attrs", str(attrs))
        attrs.update({'backgroundColor': styles.pop("backgroundColor",'')})
        data_map = {"title": attrs.pop('title', ''), "attrs": attrs.items()}
        style_value = self.get_style_build(styles)
        if style_value is not None and style_value is not '':
            data_map.update({'style': '{' + str(style_value) + '}'})
        return self.render(self.render_name(), data_map)

class ReactAttrMapperAppBarTitle(AttrMapper):
    def get_type(self):
        return "title"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_attribute_with_link('title', attr_value)

class ReactAttrMapperAppBarLeft(AttrMapper):
    def get_type(self):
        return "left"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        if attr_value is None or len(attr_value)<=0:
            return
        config.add_import("../widget/topbar","TopBarItem")
        action_items ="["
        for item in attr_value:
            action_items+= '\n\t<TopBarItem onPress={()=>console.log("DemoWidgetPage onPressItem left")}>\t%s\n\t</TopBarItem>,'%do_generate_by_type(item, config, 'row', item.get("type"))
        config.add_attribute('leftActions', action_items+"\n\t],")

class ReactAttrMapperAppBarRight(AttrMapper):
    def get_type(self):
        return "right"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        if attr_value is None or len(attr_value) <= 0:
            return
        config.add_import("../widget/topbar","TopBarItem")
        action_items ="["
        for index, item in enumerate(attr_value):
            action_items+= '\n\t<TopBarItem onPress={()=>console.log("DemoWidgetPage onPressItem  right: '+str(index)+'")}>\t%s\n\t</TopBarItem>,'%do_generate_by_type(item, config, 'row', item.get("type"))
        config.add_attribute('rightActions', action_items+"\n\t],")