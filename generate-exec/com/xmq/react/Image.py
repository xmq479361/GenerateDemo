from com.xmq.react.Base import BaseWidget
from com.xmq.react.ReactAttributes import AttrMapper


class ImageWidget(BaseWidget):
    def __init__(self, data, config):
        BaseWidget.__init__(self, data, config)
        self.attribute_mapper.append(ReactAttrMapperSource())
        self.close_self = True
        self.config.add_import("react-native","Image")

    # def get_attrs(self, parent_direction, curr_direction):
    #     src = self.get_with_def("src")
    #     print("TextWidget get_attrs", src, parent_direction, curr_direction)
    #     style_str = self.build_default_style(parent_direction, 'row')
    #     class_str = ""
    #     # style_str += self.append( 'textStyle', "font-weight")
    #     return {'style': style_str, 'class': class_str, 'source': 'require(\'../../public/imgs/%s\')'%src}

      # <Image
      #   style={styles.logo}
      #   source={{uri: 'http://facebook.github.io/react/img/logo_og.png'}}
      # />
    # def get_content_generate(self, parent_direction):
    #     return self.get_with_def("text", "")

    def render_tag_name(self):
        return "Image"

class ReactAttrMapperSource(AttrMapper):
    def get_type(self):
        return "src"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_attribute("source", "{require('../../public/imgs/%s')}"%attr_value)