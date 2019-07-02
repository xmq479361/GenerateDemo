from com.xmq.react.Base import BaseWidget


class TextWidget(BaseWidget):
    def __init__(self, data, config):
        BaseWidget.__init__(self, data, config)
        # padding = self.data.get("padding")
        # if padding is None:
        #     self.data.update({"padding": "0"})
        self.data.setdefault("padding","0")

    def get_attrs(self, parent_direction, curr_direction):
        self.build_default_style(parent_direction, 'row')
        class_str = ""
        self.append_style('fontSize',self.get_with_def("textSize"))
        self.append_style_with_link('color', self.get_with_def("textColor"))
        self.append_style_with_link('fontWeight', self.get_with_def("textStyle"))
        result = {'style': self.style_str, 'className': class_str}
        # text_style = self.data.get('textStyle', '')
        return result

    def get_content_generate(self, parent_direction):
        return self.get_with_def("text", "")

    def render_tag_name(self):
        return "Text"


class InputWidget(TextWidget):
    def __init__(self, data, config):
        TextWidget.__init__(self, data, config)

    def render_tag_name(self):
        return "TextInput"

    def get_attrs(self, parent_direction, curr_direction):
        super_attrs = super().get_attrs(parent_direction, curr_direction)
        if super_attrs is None:
            super_attrs ={}
        text = self.get_with_def("text")
        if text is not None and text is not "":
            super_attrs.update({'defaultValue':  '"'+text+ '"'})
        # else:
            # super_attrs.setdefault("style", super_attrs.get("style", "")+ self.append('text', "defaultvalue"))
        placeholder = self.get_with_def("hint")
        if placeholder is not None and placeholder is not "":
            super_attrs.update({'placeholder': '"'+placeholder+'"'})
        return super_attrs



class ButtonWidget(TextWidget):
    def __init__(self, data, config):
        TextWidget.__init__(self, data, config)

    def render_tag_name(self):
        return "Button"

    def get_attrs(self, parent_direction, curr_direction):
        super_attrs = super().get_attrs(parent_direction, curr_direction)

        color = self.get_with_def("textColor")
        if color is not None and color is not "":
            super_attrs.update({'color': '"'+color+'"'})

        if super_attrs is None:
            super_attrs ={}
        text = self.get_with_def("text")
        if text is not None and text is not "":
            super_attrs.update({'accessibilityLabel':  '"'+text+ '"'})
        return super_attrs