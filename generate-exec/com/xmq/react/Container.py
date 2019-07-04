
from com.xmq.react.Base import BaseWidget
from com.xmq.react.Image import ImageWidget
from com.xmq.react.ReactAttributes import AttrMapper
from com.xmq.react.Text import InputWidget, ButtonWidget
from com.xmq.react.Text import TextWidget


class UnkonwWidget(BaseWidget):
    def __init__(self, data, config):
        BaseWidget.__init__(self, data, config)

    def build_default_style(self, parent_direction, curr_direction=None):
        return super().build_default_style(parent_direction, curr_direction).update({"backgroundColor": 'rgba(255,0,0,0.5)',})

class SpaceViewWidget(BaseWidget):
    def __init__(self, data, config):
        BaseWidget.__init__(self, data, config)
        self.close_self = True

class ContainerWidget(BaseWidget):
    def __init__(self, data, config):
        BaseWidget.__init__(self, data, config)
        self.config.add_import("react-native",self.render_tag_name())
        self.attribute_mapper.append(ReactAttrMapperFlexDirection())
        self.attribute_mapper.append(ReactAttrMapperFlexJustifyContent())
        self.attribute_mapper.append(ReactAttrMapperFlexAlignItems())
        self.append_style("flex",1)

    # def get_attrs(self, parent_direction, curr_direction):
    #     self.build_default_style(parent_direction, curr_direction)
    #     class_str = ""
    #     self.append_style_with_link('flexDirection', self.get_with_def("flex_direction"))
    #     self.append_style_with_link('justifyContent', self.get_with_def("justify_content"))
    #     self.append_style_with_link('alignItems', self.get_with_def("align_items"))
    #     BaseWidget.append(self.style_str, "flex", 1)
    #     return {"style": self.style_str, "className": class_str}

    def generate(self, parent_direction, curr_direction=None):
        return super().generate(parent_direction, self.get_with_def('flex_direction'))

    def get_content_generate(self, parent_direction):
        child_content = ""
        children = self.get_with_def('children', [])
        if children is None or len(children) == 0:
            return child_content
        for child in children:
            if child is None or child['type'] is None:
                continue
            if child['type'] is 'container':
                child_content += ContainerWidget(child, self.config).generate(parent_direction)+"\n"
            elif child['type'] is 'input':
                child_content += InputWidget(child, self.config).generate(parent_direction)
            elif child['type'] is 'text':
                child_content += TextWidget(child, self.config).generate(parent_direction)
            elif child['type'] is 'icon':
                child_content += ImageWidget(child, self.config).generate(parent_direction)
            elif child['type'] is 'button':
                child_content += ButtonWidget(child, self.config).generate(parent_direction)
            elif child['type'] is 'spaceView':
                child_content += SpaceViewWidget(child, self.config).generate(parent_direction)
            else:
                child_content += UnkonwWidget(child, self.config).generate(parent_direction)
        return child_content

    def render_name(self):
        return "container.html"


class ReactAttrMapperFlexDirection(AttrMapper):
    def get_type(self):
        return "flex_direction"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_style_with_link("flexDirection", attr_value)


class ReactAttrMapperFlexJustifyContent(AttrMapper):
    def get_type(self):
        return "justify_content"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_style_with_link("justifyContent", attr_value)

class ReactAttrMapperFlexAlignItems(AttrMapper):
    def get_type(self):
        return "align_items"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_style_with_link("alignItems", attr_value)
