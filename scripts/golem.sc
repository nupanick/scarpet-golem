__config() -> m(
    l('stay_loaded', true),
    l('scope', 'global'),
);

__command() -> 'this is the root command';


summon() -> (
    p = player();
    p_look = str('[%ff,%ff]', p ~ 'yaw', p ~ 'pitch');
    spawn('minecraft:zombie', p ~ 'pos', '{
        NoAI:1,
        ArmorItems:[{},{},{},{
            Count:1,
            id:player_head,
            tag:{SkullOwner:"' + p ~ 'name' + '"},
        }],
        CustomName:"\\"' + p ~ 'name' + '\\"",
        Rotation:' + p_look + ',
    }');
);

FIRE_RESISTANCE='12';
snow() -> (
    p = player();
    spawn('minecraft:snow_golem', p~'pos', '{
        NoAI:1,
        ActiveEffects:[{
            Id:' + FIRE_RESISTANCE + ',
            Amplifier:0,
            Duration:999999,
        }]
    }');
);

iron() -> (
    g = spawn('minecraft:iron_golem', p~'pos')
);
