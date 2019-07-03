from com.xmq.web.Base import BaseWidget


class ImageWidget(BaseWidget):
    def __init__(self, data, config):
        BaseWidget.__init__(self, data, config)

    def get_attrs(self, parent_direction, curr_direction):
        src = self.get_with_def("src")
        print("TextWidget get_attrs", src, parent_direction, curr_direction)
        style_str = self.build_default_style(parent_direction, 'row')
        class_str = ""
        # style_str += self.append( 'textStyle', "font-weight")
        return {'style': style_str, 'class': class_str, 'src': '../static/imgs/%s'%src}

    # def get_content_generate(self, parent_direction):
    #     return self.get_with_def("text", "")

    def render_tag_name(self):
        return "img"
