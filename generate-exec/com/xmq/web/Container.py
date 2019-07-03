from com.xmq.web.Base import BaseWidget
from com.xmq.web.Image import ImageWidget
from com.xmq.web.Text import InputWidget, TextWidget, ButtonWidget


class UnkonwWidget(BaseWidget):
    def __init__(self, data, config):
        BaseWidget.__init__(self, data, config)

    def build_default_style(self, parent_direction, curr_direction=None):
        return super().build_default_style(parent_direction, curr_direction)+" background-color: #ff00006a;"

class ContainerWidget(BaseWidget):
    def __init__(self, data, config):
        BaseWidget.__init__(self, data, config)

    def get_attrs(self, parent_direction, curr_direction):
        style_str = self.build_default_style(parent_direction, curr_direction)
        class_str = ""
        style_str += self.append('display', "display")
        style_str += self.append('flex_direction', "flex-direction")
        style_str += self.append("justify_content", 'justify-content')
        style_str += self.append("align_items", 'align-items')
        return {"style": style_str, "class": class_str}

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
                child_content += ContainerWidget(child, self.config).generate(parent_direction)
            elif child['type'] is 'input':
                child_content += InputWidget(child, self.config).generate(parent_direction)
            elif child['type'] is 'text':
                child_content += TextWidget(child, self.config).generate(parent_direction)
            elif child['type'] is 'icon':
                child_content += ImageWidget(child, self.config).generate(parent_direction)
            elif child['type'] is 'spaceView':
                child_content +=BaseWidget(child, self.config).generate(parent_direction)
            elif child['type'] is 'button':
                child_content +=ButtonWidget(child, self.config).generate(parent_direction)
            else:
                child_content += UnkonwWidget(child, self.config).generate(parent_direction)
        return child_content

    # def render_name(self):
    #     return "container.html"
