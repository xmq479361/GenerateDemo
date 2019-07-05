# class WebAttributeMapper(object):


def mapper_attr_to(attribute_mappers, default_attrbute_mapper, attr_name, widget_dict, config):
    attr_mapper = attribute_mappers.get(attr_name)
    # TODO 如果未配置对应属性解释器，则采用默认解释器
    if attr_mapper is None:
        attr_mapper = default_attrbute_mapper
    if attr_mapper is None:
        return
    attr_value = widget_dict.get(attr_name, None)
    if attr_value is None:
        # TODO 是否支持并给与默认值
        if attr_mapper.support_with_default() is None:
            return
        attr_value = attr_mapper.support_with_default()
    # print("WebAttrMapper mapper_attr_to", attr_mapper)
    # print("mapper to : ", attr_name, attr_value, attr_mapper)
    return attr_mapper.mapper(attr_name, attr_value, widget_dict, config)


class WebAttrMapper(object):
    attributeMappers = {}
    default_attrbute_mapper = None

    def __init__(self):
        self.append(WebAttrMapperWidth())
        self.append(WebAttrMapperHeight())
        self.append(WebAttrMapperMargin())
        self.append(WebAttrMapperPadding())
        self.append(WebAttrMapperBackground())
        self.append(WebAttrMapperChildren())
        self.default_attrbute_mapper = WebAttrMapperDefault()

    def append(self, attr_mapper):
        if attr_mapper is None:
            return
        type = attr_mapper.get_type()
        if type is None:
            return
        self.attributeMappers.update({type: attr_mapper})

    def mapper(self, widget_dict, config):
        type = widget_dict.get('type', None)
        # print("WebAttrMapper attr_mapper type", widget, self.attributeMappers.keys())
        if type is None:
            return
        widget_attr_keys = widget_dict.keys()
        # widget_attr_keys.reverse()
        for attr_name in widget_attr_keys:
            if attr_name is "type":
                continue
            mapper_attr_to(self.attributeMappers, self.default_attrbute_mapper, attr_name, widget_dict, config)


class AttrMapper(object):
    type = None

    def get_type(self):
        return type

class WebAttrMapperDefault(AttrMapper):
    @staticmethod
    def support_with_default():
        return "default"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        # config.add_style_with_link(attr_name, attr_value)
        print("un mapper to : ", attr_name, attr_value)
        pass

class WebAttrMapperChildren(AttrMapper):
    def get_type(self):
        return "children"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        # config.add_style_with_link(attr_name, attr_value)
        pass


class WebAttrMapperBackground(AttrMapper):
    def get_type(self):
        return "background"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        config.add_style('background-color', attr_value)


class WebAttrMapperPadding(AttrMapper):
    def get_type(self):
        return "padding"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        if attr_value is not None:
            # padding_group = attr_value.split(" ")
            # if len(padding_group) == 2:
            #     config.add_style('padding', padding_group[0]+""+padding_group[1])
            # elif len(padding_group) == 4:
            #     config.add_style('padding-left', padding_group[0])
            #     config.add_style('padding-top', padding_group[1])
            #     config.add_style('padding-right', padding_group[2])
            #     config.add_style('padding-bottom', padding_group[3])
            # else:
            #  config.add_style(self.get_type(), padding_group[0])
            config.add_style(self.get_type(), attr_value)


class WebAttrMapperMargin(AttrMapper):
    def get_type(self):
        return "margin"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        if attr_value is not None:
            # margin_group = attr_value.replace('px', "").split(" ")
            # if len(margin_group) == 2:
            #     config.add_style('marginVertical', margin_group[0])
            #     config.add_style('marginHorizontal', margin_group[1])
            # elif len(margin_group) == 4:
            #     config.add_style('marginLeft', margin_group[0])
            #     config.add_style('marginTop', margin_group[1])
            #     config.add_style('marginRight', margin_group[2])
            #     config.add_style('marginBottom', margin_group[3])
            # else:
            #     config.add_style(self.get_type(), margin_group[0])
            config.add_style(self.get_type(), attr_value)


class WebAttrMapperHeight(AttrMapper):
    def get_type(self):
        return "height"

    @staticmethod
    def support_with_default():
        return "100%"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        if str(attr_value).find("px") >= 0:
            config.add_style(self.get_type(), attr_value)
        elif attr_value.isdigit():
            if config.is_parent_vertical():
                config.add_style('flex-grow', int(attr_value))
        else:
            if not config.is_parent_vertical():
                config.add_style('align-self', "stretch")
            else:
                if int(attr_value) == -1:
                    config.add_style('flex-grow', 0)
                else:
                    # PixelRatio.getPixelSizeForLayoutSize(200)
                    config.add_style('height', int(attr_value))


class WebAttrMapperWidth(AttrMapper):
    def get_type(self):
        return "width"

    @staticmethod
    def support_with_default():
        return "100%"

    def mapper(self, attr_name, attr_value, widget_dict, config):
        if str(attr_value).find("px") >= 0:
            # config.add_style(self.get_type(), int(attr_value.replace('px', "")))
            config.add_style(self.get_type(), attr_value)
        elif attr_value.isdigit():
            if not config.is_parent_vertical():
                config.add_style('flex-grow', int(attr_value))
        else:
            # print("build_default_style >>>else ", config.is_parent_vertical(), attr_value.find("px"), attr_value)
            if config.is_parent_vertical():
                config.add_style('align-self', "stretch")
                # elif attr_value.endswith("%"):
                #       config.add_style_with_link('alignSelf', "stretch")
                #     pass
                # else:
                #     config.add_style(self.get_type(), int(attr_value))
