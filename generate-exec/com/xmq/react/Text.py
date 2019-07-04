from com.xmq.react.Base import BaseWidget
from com.xmq.react.ReactAttributes import AttrMapper


# TODO 文本框
class TextWidget(BaseWidget):
    def __init__(self, data, config):
        BaseWidget.__init__(self, data, config)
        self.data.setdefault("padding", "0")
        self.config.add_import('react-native', self.render_tag_name())
        self.attribute_mapper.append(ReactAttrMapperTextColor())
        self.attribute_mapper.append(ReactAttrMapperTextStyle())
        self.attribute_mapper.append(ReactAttrMapperTextSize())

    def get_content_generate(self, parent_direction):
        return self.get_with_def("text", "")

    def render_tag_name(self):
        return "Text"

class ReactAttrMapperTextColor(AttrMapper):
    def get_type(self):
        return "textColor"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_style_with_link("color", attr_value)

class ReactAttrMapperTextStyle(AttrMapper):
    def get_type(self):
        return "textStyle"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_style_with_link("fontWeight", attr_value)

class ReactAttrMapperTextSize(AttrMapper):
    def get_type(self):
        return "textSize"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_style("fontSize", attr_value)

# TODO 文本输入框
class InputWidget(TextWidget):
    def __init__(self, data, config):
        TextWidget.__init__(self, data, config)
        self.close_self = True
        self.config.add_import('react-native', self.render_tag_name())
        self.attribute_mapper.append(ReactAttrMapperTextInputPlaceHolder())
        self.attribute_mapper.append(ReactAttrMapperTextInputDefaultValue())

    def render_tag_name(self):
        return "TextInput"

class ReactAttrMapperTextInputDefaultValue(AttrMapper):
    def get_type(self):
        return "text"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        # config.add_attribute_with_link("defaultValue", attr_value)
        pass


class ReactAttrMapperTextInputPlaceHolder(AttrMapper):
    def get_type(self):
        return "hint"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_attribute_with_link("placeholder", attr_value)

# TODO 文本按钮框
class ButtonWidget(TextWidget):
    def __init__(self, data, config):
        TextWidget.__init__(self, data, config)
        self.config.add_import('react-native', self.render_tag_name())
        self.attribute_mapper.append(ReactAttrMapperButtonColor())
        self.attribute_mapper.append(ReactAttrMapperButtonText())
        self.close_self = True

    def render_tag_name(self):
        return "Button"


class ReactAttrMapperButtonColor(AttrMapper):
    def get_type(self):
        return "color"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_attribute_with_link("color", attr_value)

class ReactAttrMapperButtonText(AttrMapper):
    def get_type(self):
        return "text"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_attribute_with_link("title", attr_value)
