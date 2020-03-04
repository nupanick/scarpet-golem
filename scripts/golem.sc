__config() -> m(
    l('stay_loaded', true),
    l('scope', 'global'),
);

__command() -> 'this is the root command';

FIRE_RESISTANCE='12';

zombie() -> (
    p = player();
    p_look = str('[%ff,%ff]', p~'yaw', p~'pitch');
    spawn('minecraft:zombie', p~'pos', '{
        NoAI:1,
        ArmorItems:[{},{},{},{
            Count:1,
            id:player_head,
            tag:{SkullOwner:"' + p~'name' + '"},
        }],
        HandItems:[{
            Count:1,
            id:"minecraft:stone_pickaxe",
        },{}],
        CustomName:"\\"' + p~'name' + '\\"",
        Rotation:' + p_look + ',
    }')
);

snow() -> (
    // Note: Snow and Iron Golems can be assigned armor or hand items,
    // but will completely ignore them. So you can't just put a helmet
    // on a snow golem to make it resist the sun...
    p = player();
    spawn('minecraft:snow_golem', p~'pos', '{
        NoAI:1,
        ActiveEffects:[{
            Id:' + FIRE_RESISTANCE + ',
            Amplifier:0,
            Duration:999999,
        }]
    }')
);

iron() -> (
    p = player();
    spawn('minecraft:iron_golem', p~'pos', '{
        NoAI:1,
        CustomName:"\\"' + p~'name' + '\\"",
    }')
);
