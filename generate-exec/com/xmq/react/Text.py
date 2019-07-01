from com.xmq.react.Base import BaseWidget


class TextWidget(BaseWidget):
    def __init__(self, data):
        BaseWidget.__init__(self, data)

    def get_attrs(self, parent_direction, curr_direction):
        text = self.get_with_def("text")
        print("TextWidget get_attrs", text, parent_direction, curr_direction)
        style_str = self.build_default_style(parent_direction, 'row')
        class_str = ""
        style_str += self.append('textSize', "font-size")
        style_str += self.append('textColor', "color")
        text_style = self.data.get('textStyle', '')
        if text_style is 'bold':
            style_str += 'font-weight: 700;'
        # elif text_style is 'bold':
        #     style_str += 'text-weight: 700;'
        # style_str += self.append( 'textStyle', "font-weight")
        return {'style': style_str, 'class': class_str}

    def get_content_generate(self, parent_direction):
        return self.get_with_def("text", "")

    def render_tag_name(self):
        return "label"


class InputWidget(TextWidget):
    def __init__(self, data):
        TextWidget.__init__(self, data)

    def render_tag_name(self):
        return "input"

    def get_attrs(self, parent_direction, curr_direction):
        # style_str = self.build_default_style(parent_direction, curr_direction)
        # class_str = ""
        # style_str += self.append('textSize', "font-size")
        # style_str += self.append('textColor', "color")
        super_attrs = super().get_attrs(parent_direction, curr_direction)
        if super_attrs is None:
            super_attrs ={}
        else:
            super_attrs.setdefault("style", super_attrs.get("style", "")+ self.append('text', "defaultvalue"))
        #     style_str = super_attrs.get('style')
        # # style_str += self.append( 'textStyle', "font-weight")
        # return {"Tag": "input", 'style': style_str, 'class': class_str, 'placeholder': self.get_with_def("hint")}
        super_attrs.update({'placeholder': self.get_with_def("hint")})
        return super_attrs
